package com.manish.LLD.RideSharingSystem.models;

import java.util.Date;

public class RideBooking {
    private String bookingId;
    private String rideId;
    private String passengerId;
    private int seatsBooked;
    private Date bookingTime;

    public RideBooking(String bookingId, String rideId, String passengerId, int seatsBooked, Date bookingTime) {
        this.bookingId = bookingId;
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.seatsBooked = seatsBooked;
        this.bookingTime = bookingTime;
    }

    // Getters
    public int getSeatsBooked() { return seatsBooked; }
}