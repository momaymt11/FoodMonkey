package com;

public class CreditCardStrategy implements com.company.PaymentStrategy {

    private String name;
    private String ccNum;
    private String cardNumber = null;
    private String cvv;
    protected String dateOfExpiry;

    protected CreditCardStrategy(){
        String expiryDate;

    }
    @Override
    public void pay() {
        System.out.print("Credit/Debit Card");
    }

}