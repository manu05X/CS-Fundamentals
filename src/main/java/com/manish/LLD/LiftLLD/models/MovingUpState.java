package com.manish.LLD.LiftLLD.models;

public class MovingUpState implements LiftState {
    @Override
    public void handleRequest(Lift lift, int floor) {
        System.out.println("Lift is moving up towards floor: " + floor);
        while (lift.getCurrentFloor() < floor) {
            lift.moveUp();
        }
        lift.stop();
    }
}
