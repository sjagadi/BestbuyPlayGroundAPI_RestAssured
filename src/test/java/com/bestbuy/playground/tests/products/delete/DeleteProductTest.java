package com.bestbuy.playground.tests.products.delete;

import com.bestbuy.playground.tests.products.AbstractProductsAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class DeleteProductTest extends AbstractProductsAPI {
    @Test
    public void ShouldDeleteProduct() {
        bestbuy.productsAPI()
                .deleteProduct(productId)
                .then().statusCode(200)
                .body("id[0]", equalTo(productId));

        bestbuy.productsAPI()
                .getProductById(productId)
                .then().statusCode(200)
                .body("total", equalTo(0));
    }
}
