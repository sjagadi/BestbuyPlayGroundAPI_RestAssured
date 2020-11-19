package com.bestbuy.playground.tests.products.get;

import com.bestbuy.playground.tests.products.AbstractProductsAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class GetProductsTest extends AbstractProductsAPI {
    @Test
    public void ShouldReturnAllProducts() {
        bestbuy.productsAPI()
                .getProducts()
                .then().statusCode(200);
    }

    @Test
    public void ShouldReturnProductWithSpecificId() {
        bestbuy.productsAPI()
                .getProductById(productId)
                .then().statusCode(200)
                .body("total", equalTo(1));
    }
}
