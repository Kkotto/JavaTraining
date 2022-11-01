package com.kkotto.model;

public class Product {
    private String name;
    private String uniqueNumber;
    private int price;
    private int count;
    private String production;

    public Product() {

    }

    public Product(String name, String uniqueNumber, int price, int count, String production) {
        this.name = name;
        this.uniqueNumber = uniqueNumber;
        this.price = price;
        this.count = count;
        this.production = production;
    }

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

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s; %s; %d; %d; %s.", this.name, this.uniqueNumber, this.price, this.count, this.production);
    }
}
