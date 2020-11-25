package com.bestbuy.playground.tests.services.add;

import com.bestbuy.playground.tests.services.AbstractServicesAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AddServiceTest extends AbstractServicesAPI {
    @Test
    public void ShouldAddServiceAndVerify() {
        bestbuy.servicesAPI()
                .getServiceById(serviceId)
                .then().statusCode(200)
                .body("total", equalTo(1))
                .body("data.name[0]", equalTo(serviceName))
                .body("data.id[0]", equalTo(serviceId))
                .body("data.createdAt[0]", notNullValue())
                .body("data.updatedAt[0]", notNullValue());
    }
}
