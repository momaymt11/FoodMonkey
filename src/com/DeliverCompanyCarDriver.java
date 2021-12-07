package com;

public class DeliverCompanyCarDriver implements Driver {
    private String name;
    public DeliverCompanyCarDriver(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String deliverOrder(int number) {
        return "Order with number " + number + " delivered";
    }

}