package com.bestbuy.playground.tests.stores.get;

import com.bestbuy.playground.tests.stores.AbstractStoresAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class GetStoresTest extends AbstractStoresAPI {

    @Test
    public void ShouldReturnAllStores() {
        bestbuy.storesAPI().getStores()
                .then().statusCode(200);
    }

    @Test
    public void ShouldReturnStoreFilterById() {
        bestbuy.storesAPI().getStoresById(storeId)
                .then().statusCode(200)
                .body("data[0].id", equalTo(storeId));
    }

    @Test
    public void ShouldReturnStoresFilterByState() {
        bestbuy.storesAPI().getStoresByState(state)
                .then().statusCode(200)
                .body("data[0].state", equalTo(state));
    }
}
