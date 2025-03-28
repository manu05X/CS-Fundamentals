package com.manish.LLD.RideSharingSystem.manager;

import com.manish.LLD.RideSharingSystem.models.enums.RideStatus;
import com.manish.LLD.RideSharingSystem.models.enums.SelectionStrategy;
import com.manish.LLD.RideSharingSystem.models.*;
import com.manish.LLD.RideSharingSystem.strategy.*;

import java.util.*;

public class RideManager {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Ride> rides = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void offerRide(String driverId, String vehicleId, String source, String destination, int availableSeats) {
        Ride ride = new Ride(UUID.randomUUID().toString(), driverId, vehicleId, source, destination, availableSeats, new Date());
        rides.put(ride.getRideId(), ride);
    }

    public Ride selectRide(String source, String destination, SelectionStrategy strategy) {
        List<Ride> availableRides = rides.values().stream()
                .filter(ride -> ride.getAvailableSeats() > 0)
                .toList();

        RideSelectionStrategy selectionStrategy = strategy == SelectionStrategy.PREFERRED_VEHICLE ?
                new PreferredVehicleStrategy() : new MostVacantStrategy();

        return selectionStrategy.selectRide(availableRides, null);
    }
}