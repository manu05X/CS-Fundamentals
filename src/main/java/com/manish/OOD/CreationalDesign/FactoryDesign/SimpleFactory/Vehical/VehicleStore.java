package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Vehical;

public class VehicleStore {
    VehicleFactory vehicleFactory;

    public VehicleStore(VehicleFactory vehicleFactory) {
        this.vehicleFactory = vehicleFactory;
    }

    public Vehicle orderVehicle(String type) {
        // Create a vehical object using the factory
        Vehicle vehicle = vehicleFactory.createVehicle(type);

        // Call the drive method on vehical
        vehicle.drive();

        return vehicle;
    }

}
