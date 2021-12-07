package com;

import java.util.Scanner;  // Import the Scanner class
import java.io.IOException;
public class DecoratorPatternCustomer {
    public static void main(String args[]) throws NumberFormatException, IOException{
        Food vf = new Krispykreme();
        int choice,menuIndex,command,promotionSelect,paymentMethod;
        ShoppingOrder order = new ShoppingOrder();
        Item item;
        DeliverCompanyCarDriver deliverDriver = new DeliverCompanyCarDriver("Momay");
        do{
            System.out.print("========== Restaurant ==========\n");
            System.out.print("[0] Krispykreme.\n");
            System.out.print("[1] Kfc.\n");
            System.out.print("[2] ChineseFood Food.\n");
            System.out.print("[3] Next.\n");
            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    vf=new Krispykreme();
                    break;
                case 1:
                    vf=new Kfc((Food) new Krispykreme());
                    break;
                case 2:
                    vf=new ChineseFood((Food) new Krispykreme());
                    break;
                default:
                    System.out.println("Other than these no food available");
                    return;
            }//end of switch
            do{
                vf.showAllMenu();
                System.out.println("[-1] Next");
                System.out.println("[-2] View item in order");
                System.out.print("Enter your menu: ");
                menuIndex = input.nextInt();
                if(menuIndex >= 0){
                    vf.addCart(menuIndex);
                }else if(menuIndex == -2){
                    vf.viewCart();
                }
            }while(menuIndex != -1);
            //Show all promotion=0 -> next/add Promotion
            for(int i=0;i<vf.numberOfOrder();i++){
                item = new Item(vf.getNameMenu(vf.getIndexOfItemInCart(i)),vf.getNumberOfItemInCart(i),vf.getPriceOfItemInCart(i));
                order.addItem(item);
            }
            order.setFee(vf.deliveryFee());
            do{
                order.summary();
                System.out.println("========== Command ==========");
                System.out.println("[0] Select Promotion");
                System.out.println("[1] Select Payment Method");
                System.out.println("[2] Place Order");
                System.out.print("Enter your choice: ");
                command = input.nextInt();
                if(command == 0){
                    for(int i=0;i<order.getNumberOfPromotion();i++){
                        System.out.println("========== Promotion ==========");
                        System.out.println("["+i+"] "+order.getNamePromotion(i)+" : "+order.getDiscountPromotion(i)+"Baht");
                    }
                    System.out.print("Enter your promotion: ");
                    promotionSelect = input.nextInt();
                    order.setPromotionSelect(promotionSelect);
                }else if(command == 1){
                    System.out.println("========== Payment Method ==========");
                    System.out.println("[0] Paypal");
                    System.out.println("[1] CreditCard");
                    System.out.print("Enter your payment method: ");
                    paymentMethod = input.nextInt();
                    if(paymentMethod == 0) order.setPaymentMethod(new PaypalStrategy("myemail@example.com", "mypwd"));
                    else if(paymentMethod == 1){
                        order.setPaymentMethod(new CreditCardStrategy());
                    }
                }
            }while(command != 2);
            System.out.println("========== Find rider ==========");
            TakewayFacade takewayFacade = new TakewayFacade(order,deliverDriver);
            takewayFacade.matchOrderWithRider();
            takewayFacade.deliveryOrder(true);
            break;
        }while(choice!=4);
    }
}