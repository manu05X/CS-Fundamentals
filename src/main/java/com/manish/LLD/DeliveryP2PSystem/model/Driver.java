package com.manish.LLD.DeliveryP2PSystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;


@Getter
@Setter
public class Driver {
    private String id;
    private String name;
    private String email;
    private String phone;

    private AtomicBoolean available;
    private AtomicReference<String> currentOrderId;

    public Driver(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.available = new AtomicBoolean(true);
        this.currentOrderId = new AtomicReference<>(null);
    }


    public boolean setAvailable(boolean status){
        return available.compareAndSet(!status, status);
    }

    public boolean assignOrder(String orderId){
        if(available.compareAndSet(true, false)){
            return currentOrderId.compareAndSet(null, orderId);
        }

        return false;
    }

    public void completeOrder(){
        currentOrderId.set(null);
        available.set(true);
    }

    public boolean isAvailable() {
        return available.get();
    }
}
