
        package com;

import com.company.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShoppingOrder {
    //List of items
    private List<Item> items;
    private float fee;
    private Promotion [] promotion = {new Promotion("None",0.0f),new Promotion("True",20.0f),new Promotion("Dtac",15.0f),new Promotion("Ais",10.0f)};
    private int promotionSelect;
    PaymentStrategy paymentMethod;
    private int orderID;
    Random r = new Random();

    public ShoppingOrder(){
        this.items=new ArrayList<Item>();
        this.fee = 0.0f;
        this.promotionSelect = 0;
        paymentMethod = () -> {

        };
        this.orderID = r.nextInt(1000);
    }

    public int getOrderID(){
        return this.orderID;
    }

    public void setPaymentMethod(CreditCardStrategy paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void setPromotionSelect(int promotionSelect){
        this.promotionSelect = promotionSelect;
    }

    public int getNumberOfPromotion(){
        return promotion.length;
    }

    public String getNamePromotion(int index){
        return promotion[index].name;
    }

    public float getDiscountPromotion(int index){
        return promotion[index].discount;
    }

    public void setFee(float fee){
        this.fee = fee;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void summary(){
        float sum = 0.0f;
        float netTotal = 0.0f;
        System.out.println("========== Summary ==========");
        for(Item item : items){
            System.out.println(item.getNumber()+"x "+item.getUpcCode()+" : "+item.getPrice()*item.getNumber()+" Baht");
            sum += item.getPrice()*item.getNumber();
        }
        netTotal = sum+fee-this.getDiscountPromotion(this.promotionSelect);
        System.out.println("SubTotal: "+sum+" Baht");
        System.out.println("Delivery Fee: "+fee+" Baht");
        System.out.println("Promotion: -"+this.getDiscountPromotion(this.promotionSelect)+" Baht");
        this.pay(this.paymentMethod);
        System.out.println(" | "+this.getNamePromotion(this.promotionSelect)+" Promotion");
        System.out.println("Net Total: "+netTotal+" Baht");
    }

    public void pay(com.company.PaymentStrategy paymentMethod){
        paymentMethod.pay();
    }

}