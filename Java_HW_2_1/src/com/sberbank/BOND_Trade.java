package com.sberbank;

public class BOND_Trade{
    private Double price;
    private String type;

    public BOND_Trade(String type,Double price){
        this.price = price;
        this.type = type;
    }
    public void printTrade(){
        System.out.println("Type: " + this.type + ", " + "Price:" + this.price);
    }
}
