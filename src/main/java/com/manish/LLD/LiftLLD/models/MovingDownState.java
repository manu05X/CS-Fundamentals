package com.manish.LLD.LiftLLD.models;

public class MovingDownState implements LiftState{
    @Override
    public void handleRequest(Lift lift, int floor) {
        System.out.println("Lift is moving down towards floor: " + floor);
        while (lift.getCurrentFloor() > floor){
            lift.moveDown();
        }

        lift.stop();
    }
}
