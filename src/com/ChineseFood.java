package com;

public class ChineseFood extends FoodDecorator{
    private String [][] name = {{"spring rolls","30"},{"tofu","30"},{"Dim Sum","28"}};
    private String [][] cart = new String[100][2];
    private int numberOfOrder = 0;
    public ChineseFood(Food newFood) {
        super(newFood);
    }
    public String getNameMenu(int index){
        // name of menu
        return this.name[index][0];
    }
    public float getPriceMenu(int index){
        // price of menu
        return Float.parseFloat(this.name[index][1]);
    }
    public int numberOfOrder(){
        return this.numberOfOrder;
    }
    public int getIndexOfItemInCart(int index){
        return Integer.parseInt(this.cart[index][0]);
    }
    public int getNumberOfItemInCart(int index){
        return Integer.parseInt(this.cart[index][1]);
    }
    public int getPriceOfItemInCart(int index){
        return Integer.parseInt(this.name[this.getIndexOfItemInCart(index)][1]);
    }
    //deliveryFee ค่าส่ง
    public float deliveryFee(){
        return super.deliveryFee()+5.0f;
    }
    public void showAllMenu(){
        System.out.println("========== ChineseFood Menu ==========");
        for(int i =0;i<name.length;i++){
            System.out.println("["+String.valueOf(i)+"] "+getNameMenu(i)+": "+getPriceMenu(i)+" Baht");
        }
    }
    public void addCart(int index){
        for(int i=0;i<cart.length;i++){
            if(this.cart[i][0] == null || this.cart[i][0].isEmpty()){
                //Add new item in cart
                cart[i][0] = String.valueOf(index);
                cart[i][1] = "1";
                numberOfOrder = numberOfOrder+1;
                break;
            }else if(this.cart[i][0].equals(String.valueOf(index))){
                cart[i][1] = String.valueOf(Integer.parseInt(cart[i][1])+1);
                break;
            }
        }
    }
    public void viewCart(){
        System.out.println("========== List of Cart ==========");
        for(int i=0;i<numberOfOrder-1;i++){
            System.out.println(this.cart[i][0]+". "+getNameMenu(Integer.parseInt(this.cart[i][0]))+" #"+this.cart[i][1]);
        }
    }
}