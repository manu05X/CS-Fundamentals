package com.manish.LLD.LiftLLD.strategy;

import com.manish.LLD.LiftLLD.models.Lift;

public class NearestRequestStrategy implements MovementStrategy{
    @Override
    public void moveToFloor(Lift lift, int floor) {
        if(lift.getCurrentFloor() < floor){
            lift.moveUp();
        } else if (lift.getCurrentFloor() > floor) {
            lift.moveDown();
        }
    }
}
