package com.manish.Codes.CoreJava.Oops.AbstractVsInterfaceExample;

// Interface with abstract methods and default method
interface Pet {
    // Abstract method
    void play();

    // Default method (concrete method)
    default void beFriendly() {
        System.out.println("Being friendly.");
    }

    // Static method (concrete method)
    static void showAffection() {
        System.out.println("Showing affection.");
    }
}
