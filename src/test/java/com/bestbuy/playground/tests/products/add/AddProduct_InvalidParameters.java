package com.bestbuy.playground.tests.products.add;

import com.bestbuy.playground.requests.ProductsAPI;
import com.bestbuy.playground.tests.products.AbstractProductsAPI;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class AddProduct_InvalidParameters extends AbstractProductsAPI {
    private JSONObject payload;

    @BeforeEach
    public void beforeAllTests() {
        payload = new ProductsAPI.ProductBuilder(name, type, upc, price, description, model).build();
    }

    @Test
    public void AddProductApiShouldRejectRequestWithNameCharactersExceedingLimit() {
        String name = faker.regexify("[A-Za-z0-9]{101}");
        payload.put("name", name);
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'name' should NOT be longer than 100 characters"));
    }

    @Test
    public void AddProductApiShouldRejectRequestWithTypeCharactersExceedingLimit() {
        String type = faker.regexify("[A-Za-z0-9]{31}");
        payload.put("type", type);
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'type' should NOT be longer than 30 characters"));
    }

    @Test
    public void AddProductApiShouldRejectRequestWithUpcCharactersExceedingLimit() {
        String upc = faker.regexify("[A-Za-z]{16}");
        payload.put("upc", upc);
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'upc' should NOT be longer than 15 characters"));
    }

    @Test
    public void AddProductApiShouldRejectRequestWithDescriptionCharactersExceedingLimit() {
        String description = faker.regexify("[A-Za-z]{101}");
        payload.put("description", description);
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'description' should NOT be longer than 100 characters"));
    }

    @Test
    public void AddProductApiShouldRejectRequestWithModelCharactersExceedingLimit() {
        String model = faker.regexify("[A-Za-z]{26}");
        payload.put("model", model);
        bestbuy.productsAPI().addProduct(payload.toString())
                .then().statusCode(400)
                .body("name", equalTo("BadRequest"))
                .body("message", equalTo("Invalid Parameters"))
                .body("code", equalTo(400))
                .body("errors[0]", equalTo("'model' should NOT be longer than 25 characters"));
    }
}
