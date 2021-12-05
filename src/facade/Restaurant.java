package facade;

public interface Restaurant {
    public int createOrder(); // Create an order to be processed by the restaurant.
    public boolean isBakingDone(); // Method to identify if the baking is done and ready to deliver.
}
