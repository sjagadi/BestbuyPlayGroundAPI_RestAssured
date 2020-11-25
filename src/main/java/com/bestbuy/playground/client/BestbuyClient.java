package com.bestbuy.playground.client;

import com.bestbuy.playground.requests.ProductsAPI;
import com.bestbuy.playground.requests.ServicesAPI;
import com.bestbuy.playground.requests.StoresAPI;

public class BestbuyClient {
    private static BestbuyClient bestbuyClient;
    private ProductsAPI bestbuyAPI;
    private ServicesAPI servicesAPI;
    private StoresAPI storesAPI;
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

    public StoresAPI storesAPI() {
        if(storesAPI == null) {
            storesAPI = new StoresAPI();
        }
        return storesAPI;
    }
}
