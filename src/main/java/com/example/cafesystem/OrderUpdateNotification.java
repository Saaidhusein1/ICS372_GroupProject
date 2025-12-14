package com.example.cafesystem;

public class OrderUpdateNotification implements UpdateOrderStrategy {
    @Override
    public String deliver(String mssg, String recipient) {
        //System.out.println("Update to: " + recipient + ": " + mssg);
        return "Update to: " + recipient + ": " + mssg;
    }
}
