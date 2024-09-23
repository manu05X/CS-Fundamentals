package com.manish.Codes.CoreJava.Oops.AbstractVsInterfaceExample;


public class AbstractVsInterfaceExample {
    public static void main(String[] args) {
        Dog1 myDog = new Dog1("Buddy");
        myDog.makeSound(); // Dog barks.
        myDog.sleep(); // Buddy is sleeping.
        myDog.play(); // Dog is playing.
        myDog.beFriendly(); // Being friendly.

        Pet.showAffection(); // Showing affection.
    }
}
