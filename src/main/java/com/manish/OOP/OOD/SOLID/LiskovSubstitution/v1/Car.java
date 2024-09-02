package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v1;

public class Car extends MotorizedVehicle {
    private int numberOfDoors;

    public Car(String make, String model, int year, int numberOfDoors) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    // Other attributes and methods specific to cars
    // ...
}
