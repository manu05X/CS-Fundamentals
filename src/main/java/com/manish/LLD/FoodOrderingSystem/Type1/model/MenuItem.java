package com.manish.LLD.FoodOrderingSystem.Type1.model;

public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
