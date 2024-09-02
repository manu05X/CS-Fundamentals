package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v0;

public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void startEngine() {
        System.out.println("Starting the engine of the vehicle.");
    }

    // Getters and setters for attributes

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

/*
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double speed; // in km/h

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0.0; // Initially, the speed is set to 0 km/h
    }

    // Getter and Setter methods for attributes

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Method to accelerate the vehicle
    public void accelerate(double acceleration) {
        // Assume a simple acceleration model
        this.speed += acceleration;
        System.out.println("The vehicle is accelerating. Current speed: " + this.speed + " km/h");
    }

    // Method to brake the vehicle
    public void brake(double deceleration) {
        // Assume a simple deceleration model
        this.speed -= deceleration;
        System.out.println("The vehicle is braking. Current speed: " + this.speed + " km/h");
    }
}
*/