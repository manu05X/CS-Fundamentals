package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Vehical;

public class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}
