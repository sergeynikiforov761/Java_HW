package com.sberbank;

public class BOND_Trade extends Trade{
    private Double price;
    private String type;

    public BOND_Trade(String type,Double price){
        this.price = price;
        this.type = type;
    }

    @Override
    public void printTrade(){
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}