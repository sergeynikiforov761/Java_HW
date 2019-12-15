package com.sberbank;

public class BondTrade extends Trade {
    private Double price;
    private String type;

    public BondTrade(String type, Double price) {
        this.price = price;
        this.type = type;
    }

    @Override
    public void printTrade() {
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}