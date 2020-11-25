package com.bestbuy.playground.tests.services.get;

import com.bestbuy.playground.tests.services.AbstractServicesAPI;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class GetServices_Nominal extends AbstractServicesAPI {
    @Test
    public void ShouldGetAllServicesList() {
        bestbuy.servicesAPI()
                .getAllServices()
                .then().statusCode(200)
                .body("total", greaterThan(1));
    }

    @Test
    public void ShouldGetServiceById() {
        bestbuy.servicesAPI()
                .getServiceById(serviceId)
                .then().statusCode(200)
                .body("total", equalTo(1));
    }

    @Test
    public void ShouldNotReturnAnyRecordWithUnavailableServiceId() {
        bestbuy.servicesAPI()
                .getServiceById(100000000)
                .then().statusCode(200)
                .body("total", equalTo(0));
    }
}
