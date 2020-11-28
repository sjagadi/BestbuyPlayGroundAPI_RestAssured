package com.bestbuy.playground.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CommonAPI extends BaseTest {
    public static RequestSpecBuilder requestSpec;
    public static final String DEFAULT_USER_NAME = prop.getProperty("username");
    public static final String DEFAULT_USER_PASSWORD = prop.getProperty("password");
    public static RequestSpecification requestSpec() {
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .setBaseUri(prop.getProperty("baseUrl"))
                .setPort(Integer.parseInt(prop.getProperty("port")))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter());

        if(prop.getProperty("log").equalsIgnoreCase("enable")) {
            requestSpec.addFilter(new AllureRestAssured());
        }
        if(prop.getProperty("authenticationType").equalsIgnoreCase("basic")) {
            requestSpec.setAuth(basic(DEFAULT_USER_NAME, DEFAULT_USER_PASSWORD));
        }
        return requestSpec.build();
    }

    public static Header createAuthorizationHeader(String username, String password) {
        if(username == null) return null;
        if(username.equals("Bearer")) {
            return new Header("Authorization", "Bearer " + password);
        }
        return new Header("Authorization", "Basic " +
                Base64.getEncoder().encodeToString(String.format("%s:%s", username, password).getBytes()));
    }

    public static synchronized ResponseSpecification responseSpec() {
        return new ResponseSpecBuilder()
                .expectHeader("Content-Type", "application/json; charset=utf-8")
                .expectHeader("X-Powered-By", "Express")
                .expectHeader("Allow", "GET,POST,PUT,PATCH,DELETE")
                .expectHeader("Vary", "Accept, Accept-Encoding")
                .expectHeader("Content-Encoding", "gzip")
                .expectHeader("Connection", "keep-alive")
                .expectHeader("Transfer-Encoding", "chunked")
                .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
                .build();
    }

    public static RequestSpecification getSpecification() {
        return given().spec(requestSpec());
    }
}
