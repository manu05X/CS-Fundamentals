package com.manish.LLD.DeliveryP2PSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRating {
    private String driverId;
    private String customerId;
    private String orderId;
    private int rating;
    private String comment;

    public DriverRating(String driverId, String customerId, String orderId, int rating, String comment) {
        this.driverId = driverId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters
    public String getDriverId() { return driverId; }
    public String getCustomerId() { return customerId; }
    public String getOrderId() { return orderId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
}