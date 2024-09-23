package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Vehical;

// Main class to test the VehicleFactory and vehicle driving behavior
public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        VehicleStore vehicalStore = new VehicleStore(vehicleFactory);

        vehicalStore.orderVehicle("car");
        vehicalStore.orderVehicle("truck");
        vehicalStore.orderVehicle("motorcycle");

        /*
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

         */
    }
}

/*

1> Vehicle Factory      2> Vehicle Store

Now a man goes to vehicle store and order a type of vehicle say "car" or "truck" .
A store will go to factory for getting the ordered vehicle. [VehicleStore(vehicleFactory);]
The factory will create the ordered vehicle by matching if they have the ordered type or not. [ if (type.equalsIgnoreCase("car"))]
If they have the type of vehicle they will construct this vehicle( "car" or "truck" ) and return the vehicle to the
store. [ return new Car();];

The store will now hand over the vehicle to customer. [here the output to cli]




 */
