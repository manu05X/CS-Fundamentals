package com.manish.LLD.RideSharingSystem.models;

import com.manish.LLD.RideSharingSystem.models.enums.RideStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Ride {
    private String rideId;
    private String driverId;
    private String vehicleId;
    private String source;
    private String destination;
    private int availableSeats;
    private Date startTime;
    private Date endTime;
    private RideStatus status;
    private List<RideBooking> bookings;

    public Ride(String rideId, String driverId, String vehicleId, String source, 
                String destination, int availableSeats, Date startTime) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.startTime = startTime;
        this.status = RideStatus.ACTIVE;
        this.bookings = new ArrayList<>();
    }

    public boolean bookRide(String passengerId, int seats) {
        if (seats > availableSeats || seats > 2) {
            return false;
        }
        bookings.add(new RideBooking(UUID.randomUUID().toString(), rideId, passengerId, seats, new Date()));
        availableSeats -= seats;
        return true;
    }

    public void endRide() {
        this.status = RideStatus.COMPLETED;
        this.endTime = new Date();
    }

    // Getters
    public String getRideId() { return rideId; }
    public String getVehicleId() { return vehicleId; }
    public int getAvailableSeats() { return availableSeats; }
}