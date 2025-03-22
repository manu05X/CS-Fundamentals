package com.manish.LLD.Parkinglot.repositories;


import com.manish.LLD.Parkinglot.models.Gate;
import com.manish.LLD.Parkinglot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();
    // here we are using tree map because we also need to do range query , and treeMap have Log(n) TC
    // where as in hash map data is not sorted so range query such as -> Find id of all the gates from 1 to 10
    // so hash map will take TC O(n) and not O(1)

    public Optional<ParkingLot> getParkingLotOfGate(Gate gate) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getGates().contains(gate)) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
