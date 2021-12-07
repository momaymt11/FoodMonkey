package com;

public interface Food {
    public float deliveryFee();
    public void showAllMenu();
    public String getNameMenu(int index);
    public float getPriceMenu(int index);
    public void addCart(int index);
    public void viewCart();
    public int numberOfOrder();
    public int getNumberOfItemInCart(int index);
    public int getIndexOfItemInCart(int index);
    public int getPriceOfItemInCart(int index);
}// End of