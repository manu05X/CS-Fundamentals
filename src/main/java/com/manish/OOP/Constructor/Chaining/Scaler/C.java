package com.manish.OOP.Constructor.Chaining.Scaler;

public class C extends B {
    int c;
    C() {
        System.out.println("C");
    }

    C(String word) {
        System.out.println("C - " + word);
    }
}
