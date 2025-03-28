package com.manish.LLD.RideSharingSystem.strategy;


import com.manish.LLD.RideSharingSystem.models.Ride;

import java.util.List;

public interface RideSelectionStrategy {
    Ride selectRide(List<Ride> rides, String preferredVehicle);
}