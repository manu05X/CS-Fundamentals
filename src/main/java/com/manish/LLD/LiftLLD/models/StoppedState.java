package com.manish.LLD.LiftLLD.models;

public class StoppedState implements LiftState{
    @Override
    public void handleRequest(Lift lift, int floor){
        System.out.println("Lift is idle, selecting floor: " + floor);
    }
}
