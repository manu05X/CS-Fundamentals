package com.manish.LLD.DeliveryP2PSystem.service;

import com.manish.LLD.DeliveryP2PSystem.enums.NotificationType;
import com.manish.LLD.DeliveryP2PSystem.model.Driver;
import com.manish.LLD.FoodOrderingSystem.model.Order;

import java.util.List;
import java.util.Optional;

public class NearestDriverStrategy implements OrderAssignmentStrategy {
    @Override
    public Optional<Driver> assignDriver(Order order, List<Driver> availableDrivers) {
        return availableDrivers.stream().findFirst();
    }
}
