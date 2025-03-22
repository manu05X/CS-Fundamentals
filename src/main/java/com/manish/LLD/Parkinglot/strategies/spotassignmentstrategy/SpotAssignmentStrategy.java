package com.manish.LLD.Parkinglot.strategies.spotassignmentstrategy;



import com.manish.LLD.Parkinglot.models.Gate;
import com.manish.LLD.Parkinglot.models.ParkingLot;
import com.manish.LLD.Parkinglot.models.ParkingSpot;
import com.manish.LLD.Parkinglot.models.VehicalType;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> findSpot(VehicalType vehicleType, ParkingLot parkingLot, Gate entryGate);

}
