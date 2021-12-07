
        package com;

public class Promotion {
    String name;
    float discount = 0.0f;
    public Promotion(String name,float discount){
        this.name = name;
        this.discount = discount;
    }
    public String getName(){
        return this.name;
    }
    public float getDiscount(){
        return this.discount;
    }
}