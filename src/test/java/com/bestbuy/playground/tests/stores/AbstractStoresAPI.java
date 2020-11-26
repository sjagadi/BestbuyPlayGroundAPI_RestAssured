package com.bestbuy.playground.tests.stores;

import com.bestbuy.playground.base.CommonAPI;
import com.bestbuy.playground.requests.StoresAPI;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AbstractStoresAPI extends CommonAPI {
    public static String name;
    public static String type;
    public static String address;
    public static String address2;
    public static String city;
    public static String state;
    public static String zip;
    public static double lat;
    public static double lng;
    public static String hours;
    public static int storeId;
    public static String payload;

    @BeforeEach
    public void addStore() {
        name = "New Store";
        type = "BigBox";
        address = "123 Fake St";
        address2 = "";
        city = "Springfield";
        state = "MN";
        zip = "55123";
        lat = 44.969658;
        lng = -93.449539;
        hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";
        payload = new StoresAPI.StoresBuilder(name, type, address, address2, city, state, zip, lat, lng, hours).build().toString();
        ValidatableResponse response = bestbuy.storesAPI().addStore(payload).then().statusCode(201);
        response.body("id", notNullValue())
                .body("name", equalTo(name))
                .body("type", equalTo(type))
                .body("address", equalTo(address))
                .body("address2", equalTo(address2))
                .body("city", equalTo(city))
                .body("state", equalTo(state))
                .body("zip", equalTo(zip))
                .body("lat", equalTo((float)lat))
                .body("lng", equalTo((float)lng))
                .body("hours", equalTo(hours));
        storeId = response.extract().jsonPath().get("id");
    }
}
