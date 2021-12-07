package com;
public class Item {

    private String upcCode;
    private float price;
    private int number;
    public Item(String upc, int number, int price){
        this.upcCode = upc;
        this.number = number;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public int getNumber(){
        return this.number;
    }
    public void setNumber(int number){
        this.number = number;
    }
}