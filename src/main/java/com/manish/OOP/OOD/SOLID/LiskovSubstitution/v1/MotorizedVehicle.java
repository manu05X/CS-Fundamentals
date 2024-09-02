package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v1;

public class MotorizedVehicle extends Vehicle {
    public MotorizedVehicle(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println("Starting the engine of the motorized vehicle.");
    }
}
