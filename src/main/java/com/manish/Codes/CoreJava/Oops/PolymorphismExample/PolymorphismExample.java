package com.manish.Codes.CoreJava.Oops.PolymorphismExample;

public class PolymorphismExample {
    public static void main(String[] args) {
        Car car = new Maruti();  // Upcasting
        car.sound();             // Calls Dog's overridden method
    }
}
