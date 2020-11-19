package com.bestbuy.playground.client;

import com.bestbuy.playground.requests.ProductsAPI;
import com.bestbuy.playground.requests.ServicesAPI;

public class BestbuyClient {
    private static BestbuyClient bestbuyClient;
    private ProductsAPI bestbuyAPI;
    private ServicesAPI servicesAPI;
    private BestbuyClient() {
    }

    public static BestbuyClient getInstance() {
        if(bestbuyClient == null) {
            synchronized (BestbuyClient.class) {
                bestbuyClient = new BestbuyClient();
            }
        }
        return bestbuyClient;
    }

    public ProductsAPI productsAPI() {
        if(bestbuyAPI == null) {
            bestbuyAPI = new ProductsAPI();
        }
        return bestbuyAPI;
    }

    public ServicesAPI servicesAPI() {
        if(servicesAPI == null) {
            servicesAPI = new ServicesAPI();
        }
        return servicesAPI;
    }
}
