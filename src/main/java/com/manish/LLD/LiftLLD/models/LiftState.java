package com.manish.LLD.LiftLLD.models;

public interface LiftState {
    public void handleRequest(Lift lift, int floor);
}
