
package com;

public class PaypalStrategy extends CreditCardStrategy implements com.company.PaymentStrategy {

    private String emailId;
    private String password;

    public PaypalStrategy(String email, String pwd){
        super();
        this.emailId=email;
        this.password=pwd;
    }

    @Override
    public void pay() {
        System.out.print("Paypal");
    }

}