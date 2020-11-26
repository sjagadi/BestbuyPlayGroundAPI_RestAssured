package com.bestbuy.playground.tests.stores.add;

import com.bestbuy.playground.tests.stores.AbstractStoresAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreateStoreTest extends AbstractStoresAPI {
    @Test
    public void ShouldVerifyAddedStore() {
        bestbuy.storesAPI().getStoresById(storeId)
                .then().statusCode(200)
                .body("data[0].id", equalTo(storeId));
    }
}
