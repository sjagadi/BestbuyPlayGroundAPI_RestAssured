package com.bestbuy.playground.tests.products.add;

import com.bestbuy.playground.requests.ProductsAPI;
import com.bestbuy.playground.tests.products.AbstractProductsAPI;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class AddProduct_MissingEmptyParameters extends AbstractProductsAPI {
    private static JSONObject payload;

    @BeforeEach
    public void beforeAllTests() {
        payload = new ProductsAPI.ProductBuilder(name, type, upc, price, description, model).build();
    }

    @Test
    public void AddProductApiShouldRejectEmptyPayload() {
        String payload = new JSONObject().toString();
        bestbuy.productsAPI().addProduct(payload)
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("should have required property 'name'"))
                .body("errors[1]", equalTo("should have required property 'type'"))
                .body("errors[2]", equalTo("should have required property 'upc'"))
                .body("errors[3]", equalTo("should have required property 'description'"))
                .body("errors[4]", equalTo("should have required property 'model'"));
    }

    @Test
    public void AddProductApiShouldRejectMissingName() {
        payload.remove("name");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("should have required property 'name'"));
    }

    @Test
    public void AddProductApiShouldRejectMissingType() {
        payload.remove("type");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("should have required property 'type'"));
    }

    @Test
    public void AddProductApiShouldRejectMissingUpc() {
        payload.remove("upc");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("should have required property 'upc'"));
    }

    @Test
    public void AddProductApiShouldRejectMissingDescription() {
        payload.remove("description");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("should have required property 'description'"));
    }

    @Test
    public void AddProductApiShouldRejectMissingModel() {
        payload.remove("model");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("should have required property 'model'"));
    }

    @Test
    public void AddProductApiShouldRejectEmptyName() {
        payload.put("name", "");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'name' should NOT be shorter than 1 characters"));
    }

    @Test
    public void AddProductApiShouldRejectEmptyType() {
        payload.put("type", "");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'type' should NOT be shorter than 1 characters"));
    }

    @Test
    public void AddProductApiShouldRejectEmptyUpc() {
        payload.put("upc", "");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'upc' should NOT be shorter than 1 characters"));
    }

    @Test
    public void AddProductApiShouldRejectEmptyDescription() {
        payload.put("description", "");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'description' should NOT be shorter than 1 characters"));
    }

    @Test
    public void AddProductApiShouldRejectEmptyModel() {
        payload.put("model", "");
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'model' should NOT be shorter than 1 characters"));
    }
}
