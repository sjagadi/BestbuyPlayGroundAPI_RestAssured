package com.bestbuy.playground.tests.services.get;

import com.bestbuy.playground.tests.services.AbstractServicesAPI;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetServices_InvalidPath extends AbstractServicesAPI {
    @Test
    public void ShouldRejectRequestWithInvalidUrl() {
        bestbuy.servicesAPI()
                .getAllServicesWithInvalidUrl()
                .then().statusCode(404)
                .body("name", equalTo("NotFound"))
                .body("message", equalTo("Page not found"))
                .body("code", equalTo(404))
                .body("className", equalTo("not-found"));
    }
}
