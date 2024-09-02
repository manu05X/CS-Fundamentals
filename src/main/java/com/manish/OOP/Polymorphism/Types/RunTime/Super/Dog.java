package com.manish.OOP.Polymorphism.Types.RunTime.Super;

public class Dog extends Animal {
    Dog() {
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("I am a dog.");
    }
}
