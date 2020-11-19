package com.bestbuy.playground.tests.products.update;

import com.bestbuy.playground.requests.ProductsAPI;
import com.bestbuy.playground.tests.products.AbstractProductsAPI;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateProductTest extends AbstractProductsAPI {
    @Test
    public void ShouldUpdateProduct() {
        name = "TV";
        type = "Home Appliance";
        upc = faker.number().digits(12);
        price = 299.99;
        description = "This is TV";
        model = "2019";
        payload = new ProductsAPI.ProductBuilder(name, type, upc, price, description, model).build().toString();
        ValidatableResponse response = bestbuy.productsAPI()
                .updateProduct(productId, payload).then()
                .statusCode(200);
        response.body("id[0]", equalTo(productId))
                .body("name[0]", equalTo(name))
                .body("type[0]", equalTo(type))
                .body("upc[0]", equalTo(upc))
                .body("price[0]", equalTo((float)price))
                .body("description[0]", equalTo(description))
                .body("model[0]", equalTo(model))
                .body("updatedAt[0]", notNullValue())
                .body("createdAt[0]", notNullValue());
    }
}
