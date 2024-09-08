package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Vehical;

// Client
public class Client {
    public static void main(String[] args) {
        VehicleFactory factory = new CarFactory(); // Switch to BikeFactory if needed
        Vehicle vehicle = factory.createVehicle();
        vehicle.drive();
    }
}


