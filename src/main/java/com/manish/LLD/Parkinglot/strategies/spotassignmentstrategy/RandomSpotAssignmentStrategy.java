package com.manish.LLD.Parkinglot.strategies.spotassignmentstrategy;



import com.manish.LLD.Parkinglot.models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(VehicalType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        for (ParkingFloor parkingFloor: parkingLot.getParkingFloor())
        {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpots())
            {
                if (parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE) &&
                        parkingSpot.getSupportedVehicleTypes().contains(vehicleType))
                {
                    return Optional.of(parkingSpot);
                }
            }
        }

        return Optional.empty();
    }
}
