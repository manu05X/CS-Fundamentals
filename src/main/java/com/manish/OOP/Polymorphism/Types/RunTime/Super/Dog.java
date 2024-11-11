package com.manish.OOP.Polymorphism.Types.RunTime.Super;

public class Dog extends Animal {
    Dog() {
    }

    public void display() {
        super.displayInfo();
        System.out.println("I am a dog.");
    }
}
