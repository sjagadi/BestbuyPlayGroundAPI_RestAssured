package com.bestbuy.playground.tests.services;

import com.bestbuy.playground.base.CommonAPI;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import static org.hamcrest.CoreMatchers.equalTo;

public abstract class AbstractServicesAPI extends CommonAPI {
    public static int serviceId;
    public static String serviceName;
    public static String payload;

    @BeforeAll
    public static void addService() {
        serviceName = "TV repair";
        payload = bestbuy.servicesAPI().payload(serviceName);
        ValidatableResponse response = bestbuy.servicesAPI()
                .addService(payload)
                .then().statusCode(201)
                .body("name", equalTo(serviceName));
        serviceId = response.extract().jsonPath().get("id");
    }
}
