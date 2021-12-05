package com.company;
public class Kfc extends FoodDecorator{

    public Kfc(Food newFood) {
        super(newFood);
    }
    private String [][] name = {{"Wing","60"},{"Coke","25"},{"Meat","50"}} ;
    public String prepareFood(){
        return super.prepareFood() +" With Chiken and Chiken Curry  ";
    }
    public double foodPrice() {
        return super.foodPrice()+150.0;
    }
}