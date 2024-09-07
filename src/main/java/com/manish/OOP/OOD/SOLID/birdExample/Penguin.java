package com.manish.OOP.OOD.SOLID.birdExample;

import com.manish.OOP.OOD.SOLID.birdExample.Interface.Swimmable;

public class Penguin extends Bird implements Swimmable {
    public Penguin(Integer weight, String colour, String size, String beakType, BirdType type) {
        super(weight, colour, size, beakType, type);
    }
    // Here Penguine cannot fly it can swim so divide bird into flyable and nonFlyable category
    @Override
    public void makeSound(){

        System.out.println(this.getType() + " is Making Sound");
    }
    @Override
    public void swim(){
        System.out.println(this.getType() + " is Swimming");
    }
}
