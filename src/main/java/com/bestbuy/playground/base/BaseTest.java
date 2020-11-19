package com.bestbuy.playground.base;

import com.bestbuy.playground.client.BestbuyClient;

public interface BaseTest {
    PropertyReader prop = PropertyReader.getInstance();
    BestbuyClient bestbuy = BestbuyClient.getInstance();
}
