package com.bestbuy.playground.base;

import com.bestbuy.playground.client.BestbuyClient;
import com.github.javafaker.Faker;

public class BaseTest {
    public static PropertyReader prop = PropertyReader.getInstance();
    public static BestbuyClient bestbuy = BestbuyClient.getInstance();
    public static Faker faker = new Faker();
}
