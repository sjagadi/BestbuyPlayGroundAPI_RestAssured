package com.bestbuy.playground.tests.services.update;

import com.bestbuy.playground.requests.ServicesAPI;
import com.bestbuy.playground.tests.services.AbstractServicesAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateServiceTest extends AbstractServicesAPI {
    @Test
    public void ShouldUpdateService() {
        serviceName = "Washing machine repair";
        payload = new ServicesAPI().payload(serviceName);
        bestbuy.servicesAPI()
                .updateService(serviceId, payload).then().statusCode(200)
                .body("id[0]", equalTo(serviceId))
                .body("name[0]", equalTo(serviceName))
                .body("updatedAt[0]", notNullValue())
                .body("createdAt[0]", notNullValue());
    }
}
