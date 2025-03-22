package com.manish.LLD.LiftLLD.strategy;

import com.manish.LLD.LiftLLD.models.Lift;

public interface MovementStrategy {
    void moveToFloor(Lift lift, int floor);
}
