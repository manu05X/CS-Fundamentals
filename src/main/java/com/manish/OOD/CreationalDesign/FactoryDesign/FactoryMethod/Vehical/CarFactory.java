package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Vehical;

// Concrete Factories
public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
