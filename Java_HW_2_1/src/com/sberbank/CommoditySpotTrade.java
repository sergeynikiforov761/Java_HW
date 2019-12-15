package com.sberbank;

public class CommoditySpotTrade {
    private Double price;
    private String type;

    public CommoditySpotTrade(String type, Double price) {
        this.price = price;
        this.type = type;
    }

    public void printTrade() {
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}
