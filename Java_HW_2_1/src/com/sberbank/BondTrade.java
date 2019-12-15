package com.sberbank;

public class BondTrade {
    private Double price;
    private String type;

    public BondTrade(String type, Double price) {
        this.price = price;
        this.type = type;
    }

    public void printTrade() {
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}
