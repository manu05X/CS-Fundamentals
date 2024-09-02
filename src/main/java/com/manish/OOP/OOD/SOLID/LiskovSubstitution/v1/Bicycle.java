package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v1;

public class Bicycle extends ManualVehicle {
    private int numberOfGears;

    public Bicycle(String make, String model, int year, int numberOfGears) {
        super(make, model, year);
        this.numberOfGears = numberOfGears;
    }

    // Other attributes and methods specific to bicycles
    // ...
}