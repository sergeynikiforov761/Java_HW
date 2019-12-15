package com.sberbank;

public class IrSwapTrade {
    private Double price;
    private String type;

    public IrSwapTrade(String type, Double price) {
        this.price = price;
        this.type = type;
    }

    public void printTrade() {
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}
