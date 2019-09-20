package com.sberbank;

public class COMMODITY_SPOT_Trade extends Trade{
    private Double price;
    private String type;

    public COMMODITY_SPOT_Trade(String type,Double price){
        this.price = price;
        this.type = type;
    }

    @Override
    public void printTrade(){
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}
