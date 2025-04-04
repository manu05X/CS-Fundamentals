package com.manish.LLD.DeliveryP2PSystem.model;

import com.manish.LLD.DeliveryP2PSystem.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String id;
    private String customerId;
    private String itemId;
    private String deliveryAddress;
    private OrderStatus status;
    private String driverId;
    private long creationTime;
    private long pickupTime;
    private long deliveryTime;
    private long cancellationTime;

    public Order(String id, String customerId, String itemId) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
        this.status = OrderStatus.PLACED;
        this.creationTime = System.currentTimeMillis();
    }

    public synchronized boolean assignDriver(String driverId){
        if(status == OrderStatus.PLACED){
            this.driverId = driverId;
            status = OrderStatus.ASSIGNED;
            return true;
        }
        return false;
    }

    public synchronized boolean pickup(){
        if(status == OrderStatus.ASSIGNED){
            status = OrderStatus.PICKED_UP;
            pickupTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public synchronized boolean deliver(){
        if (status == OrderStatus.PICKED_UP){
            status = OrderStatus.DELIVERED;
            deliveryTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public synchronized boolean cancel(){
        if(status == OrderStatus.PLACED || status == OrderStatus.ASSIGNED){
            status = OrderStatus.CANCELLED;
            cancellationTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }


}
