package com.bestbuy.playground.requests;

import com.bestbuy.playground.base.CommonAPI;
import io.restassured.response.Response;
import org.json.JSONObject;

public class StoresAPI extends CommonAPI {
    public Response getStores() {
        return getSpecification()
                .get(ProductsApiUrl.getStoresUrl());
    }

    public Response getStoresById(int id) {
        return getSpecification()
                .param("id", id)
                .get(ProductsApiUrl.getStoresUrl());
    }

    public Response getStoresByState(String state) {
        return getSpecification()
                .param("state", state)
                .get(ProductsApiUrl.getStoresUrl());
    }

    public Response addStore(String payload) {
        return getSpecification()
                .body(payload)
                .post(ProductsApiUrl.getStoresUrl());
    }

    public Response updateStore(int storeId, String payload) {
        return getSpecification()
                .param("id", storeId)
                .body(payload)
                .patch(ProductsApiUrl.getStoresUrl());
    }

    public Response deleteStore(int id) {
        return getSpecification()
                .param("id", id)
                .delete(ProductsApiUrl.getStoresUrl());
    }

    public static class ProductsApiUrl {
        static String getStoresUrl() {
            return "/stores";
        }
    }

    public static class StoresBuilder {
        private final String name;
        private final String type;
        private final String address;
        private final String address2;
        private final String city;
        private final String state;
        private final String zip;
        private final double lat;
        private final double lng;
        private final String hours;
        public StoresBuilder(String name, String type, String address, String address2, String city, String state, String zip, double lat, double lng, String hours) {
            this.name = name;
            this.type = type;
            this.address = address;
            this.address2 = address2;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.lat = lat;
            this.lng = lng;
            this.hours = hours;
        }
        public JSONObject build() {
            return new JSONObject()
                    .put("name", name)
                    .put("type", type)
                    .put("address", address)
                    .put("address2", address2)
                    .put("city", city)
                    .put("state", state)
                    .put("zip", zip)
                    .put("lat", lat)
                    .put("lng", lng)
                    .put("hours", hours);
        }
    }
}
