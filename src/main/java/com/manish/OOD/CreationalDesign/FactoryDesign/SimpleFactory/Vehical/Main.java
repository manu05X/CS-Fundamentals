package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Vehical;

// Main class to test the VehicleFactory and vehicle driving behavior
public class Main {
    public static void main(String[] args) {
        // Create a Car object using the factory
        Vehicle car = VehicleFactory.createVehicle("car");
        // Create a Truck object using the factory
        Vehicle truck = VehicleFactory.createVehicle("truck");
        // Create a Motorcycle object using the factory
        Vehicle motorcycle = VehicleFactory.createVehicle("motorcycle");

        // Call the drive method on the car
        car.drive(); // Output: "Driving a car."
        // Call the drive method on the truck
        truck.drive(); // Output: "Driving a truck."
        // Call the drive method on the motorcycle
        motorcycle.drive(); // Output: "Driving a motorcycle."
    }
}
