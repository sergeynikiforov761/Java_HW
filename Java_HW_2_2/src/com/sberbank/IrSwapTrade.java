package com.sberbank;

public class IrSwapTrade extends Trade {
    private Double price;
    private String type;

    public IrSwapTrade(String type, Double price) {
        this.price = price;
        this.type = type;
    }

    @Override
    public void printTrade() {
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}

