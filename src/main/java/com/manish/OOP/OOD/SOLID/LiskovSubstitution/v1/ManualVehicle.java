package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v1;

public class ManualVehicle extends Vehicle {
    public ManualVehicle(String make, String model, int year) {
        super(make, model, year);
    }

    // No need to override start() for manual vehicles
}
