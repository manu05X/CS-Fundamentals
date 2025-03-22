package com.manish.LLD.LiftLLD.service;

import com.manish.LLD.LiftLLD.models.Lift;
import com.manish.LLD.LiftLLD.strategy.NearestRequestStrategy;

public class LiftController {
    private Lift lift;
    private NearestRequestStrategy movementStrategy;

    public LiftController(Lift lift){
        this.lift = lift;
        this.movementStrategy = new NearestRequestStrategy();
    }

    public void requestLift(int floor){
        System.out.println("User request lift at floor: "+ floor);
        movementStrategy.moveToFloor(lift, floor);
    }

    public void selectFloor(int floor){
        System.out.println("User request lift at floor: "+ floor);
        movementStrategy.moveToFloor(lift, floor);
    }

    public void handleEmergency() {
        System.out.println("Emergency Activated: Lift Doors Opened Manually!");
    }
}
