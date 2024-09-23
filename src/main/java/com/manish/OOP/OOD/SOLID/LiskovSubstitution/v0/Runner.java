package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v0;

public class Runner {
    public static void main(String[] args) {
        // Create a Vehicle
        Vehicle vehicle = new Vehicle("Toyota", "Camry", 2022);

        // Create a Car
        Car car = new Car("Honda", "Civic", 2022, 4);

        // Call startEngine method on both
        vehicle.startEngine(); // Output: Starting the engine of the vehicle.
        car.startEngine();     // Output: Starting the engine of the car.
    }
}


/*
// Example usage in com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class
public class Runner {
    public static void main(String[] args) {
        // Creating a generic Vehicle
        Vehicle genericVehicle = new Vehicle("GenericBrand", "GenericModel", 2022);

        // Accelerating the generic vehicle
        genericVehicle.accelerate(30.0);

        // Creating a specific Car
        Car myCar = new Car("Toyota", "Camry", 2020, 4);

        // Accelerating and braking the car
        myCar.accelerate(40.0);
        myCar.brake(15.0);

        // Accessing attributes of the Car class
        System.out.println("Brand: " + myCar.getBrand());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Number of Doors: " + myCar.getNumberOfDoors());
    }
}
*/


/*
In this example:

The Vehicle class has attributes such as brand, model, year, and speed, along with methods to accelerate and brake.

The Car class is a subclass of Vehicle and has an additional attribute numberOfDoors. It inherits the attributes and methods from the Vehicle class and can have its own specific attributes and methods.

The com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class demonstrates creating instances of both the generic Vehicle class and the specific Car class and performing operations such as accelerating and braking.
*/