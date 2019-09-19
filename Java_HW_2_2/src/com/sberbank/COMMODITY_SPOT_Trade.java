package com.sberbank;

public class COMMODITY_SPOT_Trade{
    private Double price;
    private String type;

    public COMMODITY_SPOT_Trade(String type,Double price){
        this.price = price;
        this.type = type;
    }
    public void printTrade(){
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}
