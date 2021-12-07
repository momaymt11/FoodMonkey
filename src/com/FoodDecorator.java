package com;

public abstract class FoodDecorator implements Food{
    private Food newFood;
    public FoodDecorator(Food newFood)  {
        this.newFood = newFood;
    }
    @Override
    public float deliveryFee(){
        return newFood.deliveryFee();
    }
    public void showAllMenu(){
        newFood.showAllMenu();
    }
    public String getNameMenu(int index){
        return newFood.getNameMenu(index);
    }
    public float getPriceMenu(int index){
        return newFood.getPriceMenu(index);
    }
    public void viewCart(){
        newFood.viewCart();
    }
    public int numberOfOrder(){
        return newFood.numberOfOrder();
    }
    public int getNumberOfItemInCart(int index){
        return newFood.getNumberOfItemInCart(index);
    }
    public int getIndexOfItemInCart(int index){
        return newFood.getIndexOfItemInCart(index);
    }
    public int getPriceOfItemInCart(int index){
        return newFood.getPriceOfItemInCart(index);
    }
}