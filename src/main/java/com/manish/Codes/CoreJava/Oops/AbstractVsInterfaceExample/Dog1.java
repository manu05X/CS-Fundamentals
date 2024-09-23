package com.manish.Codes.CoreJava.Oops.AbstractVsInterfaceExample;

// Class that extends abstract class and implements interface
class Dog1 extends Animal1 implements Pet {
    public Dog1(String name) {
        super(name); // Call the constructor of the abstract class
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing.");
    }
}
