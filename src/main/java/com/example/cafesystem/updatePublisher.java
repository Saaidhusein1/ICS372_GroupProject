package com.example.cafesystem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class updatePublisher {
    private List<Subscriber> subscribers = new LinkedList<>();
    private List<String> updates = new LinkedList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public String publishUpdate(String mssg){
        String str = " ";
        for (Subscriber subscriber : subscribers) {
            str += subscriber.updateLabel(mssg) + ", ";
        }
        return str;
    }
}
