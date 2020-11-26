package com.bestbuy.playground.tests.stores.delete;

import com.bestbuy.playground.tests.stores.AbstractStoresAPI;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class DeleteStoreTest extends AbstractStoresAPI {
    @Test
    public void ShouldDeleteStore() {
        bestbuy.storesAPI().deleteStore(storeId)
                .then().statusCode(200);

        bestbuy.storesAPI().getStoresById(storeId)
                .then().statusCode(200)
                .body("total", equalTo(0));
    }
}
