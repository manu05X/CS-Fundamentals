package com.manish.OOP.OOD.SOLID.birdExample;

import com.manish.OOP.OOD.SOLID.birdExample.Interface.FlyingBehaviour;

public class GlidingBehaviour implements FlyingBehaviour {
    @Override
    public void makeFly() {
        System.out.println("Gliding");
    }

}