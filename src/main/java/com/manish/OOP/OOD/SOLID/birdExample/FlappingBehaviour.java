package com.manish.OOP.OOD.SOLID.birdExample;

import main.OOD.SOLID.birdExample.Interface.FlyingBehaviour;

public class FlappingBehaviour implements FlyingBehaviour {
    @Override
    public void makeFly() {
        System.out.println("Flapping");
    }
}