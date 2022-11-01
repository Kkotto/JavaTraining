package com.kkotto.model;

public class Product {
    private String name;
    private String uniqueNumber;
    private int price;
    private int count;
    private String production;

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
