package com.manish.LLD.RideSharingSystem.strategy;

import com.manish.LLD.RideSharingSystem.models.Ride;

import java.util.List;

public class PreferredVehicleStrategy implements RideSelectionStrategy {
    @Override
    public Ride selectRide(List<Ride> rides, String preferredVehicle) {
        return rides.stream()
                .filter(ride -> ride.getAvailableSeats() > 0)
                .findFirst()
                .orElse(null);
    }
}