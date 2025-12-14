package com.example.cafesystem;

public class InventoryData {
    private double lbs_coffee_beans = 5;
    private double gallons_milk = 5;
    private double lbs_sugar = 5;
    private double lbs_butter = 5;
    private double choco_chips = 5;

    public double getLbs_coffee_beans() {
        return lbs_coffee_beans;
    }

    public void setLbs_coffee_beans(double lbs_coffee_beans) {
        this.lbs_coffee_beans -= lbs_coffee_beans;
    }

    public double getGallons_milk() {
        return gallons_milk;
    }

    public void setGallons_milk(double gallons_milk) {
        this.gallons_milk -= gallons_milk;
    }

    public double getLbs_sugar() {
        return lbs_sugar;
    }

    public void setLbs_sugar(double lbs_sugar) {
        this.lbs_sugar -= lbs_sugar;
    }

    public double getLbs_butter() {
        return lbs_butter;
    }

    public void setLbs_butter(double lbs_butter) {
        this.lbs_butter -= lbs_butter;
    }

    public double getChoco_chips() {
        return choco_chips;
    }

    public void setChoco_chips(double choco_chips) {
        this.choco_chips -= choco_chips;
    }
}
