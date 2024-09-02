package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v1;

public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("Starting the vehicle.");
    }

    // Getters and setters for attributes
    // ...
}