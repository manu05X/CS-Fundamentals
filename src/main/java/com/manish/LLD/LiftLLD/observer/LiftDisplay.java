package com.manish.LLD.LiftLLD.observer;

public class LiftDisplay implements Observer{
    @Override
    public void update(int floor) {
        System.out.println("Lift Display Updated: Now at Floor " + floor);
    }
}
