package com.manish.LLD.DeliveryP2PSystem.service;


import com.manish.LLD.DeliveryP2PSystem.model.Driver;
import com.manish.LLD.FoodOrderingSystem.Type1.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderAssignmentStrategy {
    Optional<Driver> assignDriver(Order order, List<Driver> availableDrivers);
}