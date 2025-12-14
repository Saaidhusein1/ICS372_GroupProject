package com.example.cafesystem;

public class Customer implements Subscriber{
    private String name;
    private UpdateOrderStrategy strategy;

    public Customer(String name, UpdateOrderStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }
    @Override
    public String updateLabel(String mssg) {
        return strategy.deliver("Messge is: " + mssg, name);
    }
}
