package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Vehical;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(){
        return new Truck();
    }
}
