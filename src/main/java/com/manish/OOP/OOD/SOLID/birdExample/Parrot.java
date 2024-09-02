package com.manish.OOP.OOD.SOLID.birdExample;

import main.OOD.SOLID.birdExample.Interface.Flyable;
import main.OOD.SOLID.birdExample.Interface.FlyingBehaviour;

public class Parrot extends Bird implements Flyable {
    private FlyingBehaviour flyingBehaviour;
    public Parrot(Integer weight, String colour, String size, String beakType, BirdType type, FlyingBehaviour flyingBehaviour) {
        super(weight, colour, size, beakType, type);
        this.flyingBehaviour = flyingBehaviour;
    }
    @Override
    public void fly(){
        //System.out.println(this.getType() + " is Flying");
        flyingBehaviour.makeFly();
    }
    @Override
    public void makeSound(){
        //TODO Auto-generated method stub
    }
}
