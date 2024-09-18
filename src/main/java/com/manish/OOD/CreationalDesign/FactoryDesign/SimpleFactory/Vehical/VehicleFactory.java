package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Vehical;

// Factory class to create instances of Vehicle based on input type
public class VehicleFactory {

    // Static method to create a vehicle based on the provided type
    public static Vehicle createVehicle(String type) {
        // Check if the input type is "car", create and return a Car instance
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        }
        // Check if the input type is "truck", create and return a Truck instance
        else if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        }
        // Check if the input type is "motorcycle", create and return a Motorcycle instance
        else if (type.equalsIgnoreCase("motorcycle")) {
            return new Motorcycle();
        }
        // If the type is not recognized, throw an exception
        else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}
