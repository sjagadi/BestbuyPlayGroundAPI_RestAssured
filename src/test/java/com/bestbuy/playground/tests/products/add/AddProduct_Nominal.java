package com.bestbuy.playground.tests.products.add;

import com.bestbuy.playground.tests.products.AbstractProductsAPI;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AddProduct_Nominal extends AbstractProductsAPI {
    @Test
    public void ShouldAddProductAndVerify() {
        bestbuy.productsAPI()
                .getProductById(productId)
                .then().statusCode(200)
                .body("data.id[0]", equalTo(productId))
                .body("data.name[0]", equalTo(name))
                .body("data.type[0]", equalTo(type))
                .body("data.upc[0]", equalTo(upc))
                .body("data.description[0]", equalTo(description))
                .body("data.model[0]", equalTo(model))
                .body("data.updatedAt[0]", notNullValue())
                .body("data.createdAt[0]", notNullValue());
    }
}
