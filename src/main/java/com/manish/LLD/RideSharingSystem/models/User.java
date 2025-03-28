package com.manish.LLD.RideSharingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private List<Vehicle> vehicles;
    private int ridesOffered;
    private int ridesTaken;

    public User(String userId, String name, String gender, int age, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
        this.ridesOffered = 0;
        this.ridesTaken = 0;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void incrementRidesOffered() {
        ridesOffered++;
    }

    public void incrementRidesTaken() {
        ridesTaken++;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public List<Vehicle> getVehicles() { return vehicles; }
    public int getRidesOffered() { return ridesOffered; }
    public int getRidesTaken() { return ridesTaken; }
}
