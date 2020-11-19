package com.bestbuy.playground.tests.products;

import com.bestbuy.playground.base.CommonAPI;
import com.bestbuy.playground.requests.ProductsAPI;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public abstract class AbstractProductsAPI extends CommonAPI {
    public static String name;
    public static String type;
    public static String upc;
    public static double price;
    public static String description;
    public static String model;
    public static String payload;
    public static int productId;

    @BeforeAll
    public static void addProduct() {
        name = "Fan";
        type = "Appliance";
        upc = faker.number().digits(12);
        price = 99.99;
        description = "This is fan";
        model = "2020";
        payload = new ProductsAPI.ProductBuilder(name, type, upc, price, description, model).build().toString();
        ValidatableResponse response = bestbuy.productsAPI().addProduct(payload).then().statusCode(201);
        response.body("id", notNullValue())
                .body("name", equalTo(name))
                .body("type", equalTo(type))
                .body("upc", equalTo(upc))
                .body("price", equalTo((float)price))
                .body("description", equalTo(description))
                .body("model", equalTo(model))
                .body("updatedAt", notNullValue())
                .body("createdAt", notNullValue());
        productId = response.extract().jsonPath().get("id");
    }
}
