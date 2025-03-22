package com.manish.LLD.Parkinglot.models;

public class Vehical extends BaseModel {
    private String vehicleNumber;
    private VehicalType vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicalType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicalType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
