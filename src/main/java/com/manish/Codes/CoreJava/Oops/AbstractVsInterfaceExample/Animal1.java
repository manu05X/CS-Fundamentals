package com.manish.Codes.CoreJava.Oops.AbstractVsInterfaceExample;

// Abstract class
abstract class Animal1 {
    private String name;

    // Constructor in abstract class
    public Animal1(String name) {
        this.name = name;
    }

    // Abstract method (no implementation)
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}
