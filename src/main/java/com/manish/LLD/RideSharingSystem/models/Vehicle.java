package com.manish.LLD.RideSharingSystem.models;

public class Vehicle {
    private String vehicleId;
    private String ownerId;
    private String make;
    private String model;
    private String licensePlate;
    private String color;
    private int capacity;

    public Vehicle(String vehicleId, String ownerId, String make, String model, 
                   String licensePlate, String color, int capacity) {
        this.vehicleId = vehicleId;
        this.ownerId = ownerId;
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.color = color;
        this.capacity = capacity;
    }

    // Getters
    public String getVehicleId() { return vehicleId; }
    public String getOwnerId() { return ownerId; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getCapacity() { return capacity; }
}