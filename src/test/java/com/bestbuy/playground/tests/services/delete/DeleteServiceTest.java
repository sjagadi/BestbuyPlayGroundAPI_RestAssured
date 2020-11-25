package com.bestbuy.playground.tests.services.delete;

import com.bestbuy.playground.tests.services.AbstractServicesAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteServiceTest extends AbstractServicesAPI {
    @Test
    public void ShouldDeleteServiceAndVerify() {
        bestbuy.servicesAPI()
                .deleteService(serviceId)
                .then().statusCode(200)
                .body("id[0]",equalTo(serviceId))
                .body("name[0]", equalTo(serviceName))
                .body("createdAt[0]", notNullValue())
                .body("updatedAt[0]", notNullValue());

        bestbuy.productsAPI()
                .getProductById(serviceId)
                .then().statusCode(200)
                .body("total", equalTo(0));
    }
}
