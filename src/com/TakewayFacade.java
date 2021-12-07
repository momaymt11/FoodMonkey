package com;

public class TakewayFacade { // Facade interface class.
    private ShoppingOrder order;
    private Driver driver;
    private int orderNbr;

    public TakewayFacade(ShoppingOrder order, Driver driver){ // The constructor receives a Restaurant and a Driver objects.
        this.order = order;
        this.driver = driver;
    }

    public void matchOrderWithRider() { // This is the method that do all actions. Actions are the Restaurant and Driver methods that need to be called.
        orderNbr = this.order.getOrderID();
        System.out.print("Order with number: " + orderNbr);
        System.out.println(" with rider: "+driver.getName());
    }

    public void deliveryOrder(Boolean status){
        if(status) {
            System.out.println("Dish is Ready to deliver!!");
            String deliverProcessed = this.driver.deliverOrder(orderNbr);
            System.out.println(deliverProcessed);
        }else{
            System.out.println("Have a some error contact with monkey delivery");
        }
    }
}