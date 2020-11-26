package com.bestbuy.playground.tests.stores.update;

import com.bestbuy.playground.requests.StoresAPI;
import com.bestbuy.playground.tests.stores.AbstractStoresAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class UpdateStoreTest extends AbstractStoresAPI {

    @Test
    public void ShouldUpdateStore() {
        String name = "Updated name";
        String type = "Updated type";
        String address = "Updated address";
        String address2 = "";
        String city = "Florida";
        String state = "Florida";
        String zip = "1030";
        double lat = 45.969658;
        double lng = -94.449539;
        String hours = "Updated hours";
        payload = new StoresAPI.StoresBuilder(name, type, address, address2, city, state, zip, lat, lng, hours).build().toString();
        bestbuy.storesAPI().updateStore(storeId, payload)
                .then().statusCode(200);

        bestbuy.storesAPI().getStoresById(storeId)
                .then().statusCode(200)
                .body("data[0].id", equalTo(storeId))
                .body("data[0].name", equalTo(name))
                .body("data[0].type", equalTo(type))
                .body("data[0].address", equalTo(address))
                .body("data[0].address2", equalTo(address2))
                .body("data[0].city", equalTo(city))
                .body("data[0].state", equalTo(state))
                .body("data[0].zip", equalTo(zip))
                .body("data[0].lat", equalTo((float) lat))
                .body("data[0].lng", equalTo((float) lng))
                .body("data[0].hours", equalTo(hours));
    }
}
