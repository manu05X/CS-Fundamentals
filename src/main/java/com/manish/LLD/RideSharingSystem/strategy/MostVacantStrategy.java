package com.manish.LLD.RideSharingSystem.strategy;

import com.manish.LLD.RideSharingSystem.models.Ride;

import java.util.Comparator;
import java.util.List;

public class MostVacantStrategy implements RideSelectionStrategy {
    @Override
    public Ride selectRide(List<Ride> rides, String preferredVehicle) {
        return rides.stream()
                .filter(ride -> ride.getAvailableSeats() > 0)
                .max(Comparator.comparingInt(Ride::getAvailableSeats))
                .orElse(null);
    }
}