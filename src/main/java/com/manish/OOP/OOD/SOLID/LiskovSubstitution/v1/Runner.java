package com.manish.OOP.OOD.SOLID.LiskovSubstitution.v1;

public class Runner {
    public static void main(String[] args) {
        // Create instances of MotorizedVehicle, ManualVehicle, Car, and Bicycle
        MotorizedVehicle motorizedVehicle = new MotorizedVehicle("Toyota", "Camry", 2022);
        ManualVehicle manualVehicle = new ManualVehicle("SomeBrand", "SomeModel", 2022);
        Car car = new Car("Honda", "Civic", 2022, 4);
        Bicycle bicycle = new Bicycle("Giant", "Defy", 2022, 21);

        // Call start method on all instances
        motorizedVehicle.start(); // Output: Starting the engine of the motorized vehicle.
        manualVehicle.start();    // Output: Starting the vehicle.
        car.start();              // Output: Starting the engine of the motorized vehicle. (inherited from MotorizedVehicle)
        bicycle.start();          // Output: Starting the vehicle. (inherited from ManualVehicle)
    }
}
/*
With this implementation, we have satisfied the LSP.

Car is substitutable with its superclass, Motorized, and Bicycle is substitutable with its superclass, Manual, without breaking the functionality.

Their methods can also override the methods of the superclass.

Conclusion
The LSP is an important principle that should be extended to the level of system architecture. A small violation of the substitutability of classes can cause the system to break down, which is why we should always be on the lookout for violations. A few benefits of the LSP are provided below:

It avoids the generalization of concepts that may not be needed in the future.

It makes the code maintainable and easier to upgrade.
*/