package com.bestbuy.playground.requests;

import com.bestbuy.playground.base.CommonAPI;
import io.restassured.response.Response;
import org.json.JSONObject;

public class ProductsAPI extends CommonAPI {
    public Response getProducts() {
        return getSpecification()
                .get(ProductsApiUrl.getProductsUrl());
    }

    public Response getProductById(int productId) {
        return getSpecification()
                .param("id", productId)
                .get(ProductsApiUrl.getProductsUrl());
    }

    public Response addProduct(String payload) {
        return getSpecification()
                .body(payload).post(ProductsApiUrl.getProductsUrl());
    }

    public Response deleteProduct(int productId) {
        return getSpecification()
                .param("id", productId)
                .delete(ProductsApiUrl.getProductsUrl());
    }

    public Response updateProduct(int productId, String payload) {
        return getSpecification()
                .param("id", productId)
                .body(payload)
                .patch(ProductsApiUrl.getProductsUrl());
    }

    public static class ProductsApiUrl {
        static String getProductsUrl() {
            return "/products";
        }
    }
    public static class ProductBuilder {
        private final String name;
        private final String type;
        private final String upc;
        private final double price;
        private final String description;
        private final String model;
        public ProductBuilder(String name, String type, String upc, double price, String description, String model) {
            this.name = name;
            this.type = type;
            this.upc = upc;
            this.price = price;
            this.description = description;
            this.model = model;
        }
        public JSONObject build() {
            return new JSONObject()
                    .put("name", name)
                    .put("type", type)
                    .put("upc", upc)
                    .put("price", price)
                    .put("description", description)
                    .put("model", model);
        }
    }
}
