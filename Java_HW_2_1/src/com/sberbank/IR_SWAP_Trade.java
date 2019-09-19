package com.sberbank;

public class IR_SWAP_Trade{
    private Double price;
    private String type;

    public IR_SWAP_Trade(String type,Double price){
        this.price = price;
        this.type = type;
    }
    public void printTrade(){
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}
