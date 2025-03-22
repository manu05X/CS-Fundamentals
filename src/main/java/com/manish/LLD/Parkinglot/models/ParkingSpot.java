package com.manish.LLD.Parkinglot.models;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private int number;
    private Vehical vehical;
    private List<VehicalType> supportedVehicleTypes;
    private SpotStatus spotStatus;

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public Vehical getVehical() { return vehical; }
    public void setVehical(Vehical vehical) { this.vehical = vehical; }

    public List<VehicalType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }
    public void setSupportedVehicleTypes(List<VehicalType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public SpotStatus getSpotStatus() { return spotStatus; }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }
}
