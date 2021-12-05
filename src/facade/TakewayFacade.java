package facade;

public class TakewayFacade { // Facade interface class.
    private Restaurant restaurant;
    private Driver driver;
    public TakewayFacade(Restaurant restaurant, Driver driver){ // The constructor receives a Restaurant and a Driver objects.
        this.restaurant = restaurant;
        this.driver = driver;
    }

    public void makeOrder() { // This is the method that do all actions. Actions are the Restaurant and Driver methods that need to be called.
        int orderNbr = this.restaurant.createOrder();
        System.out.println("Order with number " + orderNbr + " created.");
        boolean isReady = this.restaurant.isBakingDone();
        if(isReady) {
            System.out.println("Dish is Ready to deliver!!");
            String deliverProcessed = this.driver.deliverOrder(orderNbr);
            System.out.println(deliverProcessed);
        }
    }
}