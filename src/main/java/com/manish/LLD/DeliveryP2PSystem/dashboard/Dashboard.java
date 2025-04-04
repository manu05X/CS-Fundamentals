package com.manish.LLD.DeliveryP2PSystem.dashboard;

import com.manish.LLD.DeliveryP2PSystem.model.Driver;
import com.manish.LLD.DeliveryP2PSystem.system.DeliverySystem;

import java.util.List;
import java.util.stream.Collectors;

public class Dashboard {
    private DeliverySystem deliverySystem;

    public Dashboard(DeliverySystem deliverySystem) {
        this.deliverySystem = deliverySystem;
    }

    public List<Driver> getTopDriversByRating(int limit) {
        return deliverySystem.getAllDrivers().stream()
                .sorted((d1, d2) -> Double.compare(deliverySystem.getAverageRating(d2.getId()),
                        deliverySystem.getAverageRating(d1.getId())))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Driver> getTopDriversByOrdersCompleted(int limit) {
        return deliverySystem.getAllDrivers().stream()
                .sorted((d1, d2) -> Integer.compare(deliverySystem.getCompletedOrdersCount(d2.getId()),
                        deliverySystem.getCompletedOrdersCount(d1.getId())))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
