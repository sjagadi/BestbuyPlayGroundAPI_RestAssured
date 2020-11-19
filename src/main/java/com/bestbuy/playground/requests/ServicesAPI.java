package com.bestbuy.playground.requests;

import com.bestbuy.playground.base.CommonAPI;
import io.restassured.response.Response;
import org.json.JSONObject;

public class ServicesAPI extends CommonAPI {
    public Response getAllServices() {
        return getSpecification().get(ServicesApiUrl.getServicesUrl());
    }

    public Response getAllServicesWithInvalidUrl() {
        return getSpecification().get(ServicesApiUrl.getServicesInvalidUrl());
    }

    public Response getServiceById(int serviceId) {
        return getSpecification()
                .param("id", serviceId)
                .get(ServicesApiUrl.getServicesUrl());
    }

    public Response addService(String payload) {
        return getSpecification()
                .body(payload)
                .post(ServicesApiUrl.getServicesUrl());
    }

    public Response updateService(int serviceId, String payload) {
        return getSpecification()
                .param("id", serviceId)
                .body(payload)
                .patch(ServicesApiUrl.getServicesUrl());
    }

    public Response deleteService(int serviceId) {
        return getSpecification()
                .param("id", serviceId)
                .delete(ServicesApiUrl.getServicesUrl());
    }

    public String payload(String serviceName) {
        return new JSONObject().put("name", serviceName).toString();
    }

    public static class ServicesApiUrl {
        public static String getServicesUrl() {
            return "/services";
        }

        public static String getServicesInvalidUrl() {
            return "/test";
        }
    }
}
