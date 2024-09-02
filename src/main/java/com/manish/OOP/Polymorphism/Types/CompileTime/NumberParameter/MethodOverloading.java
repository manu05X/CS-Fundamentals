package com.manish.OOP.Polymorphism.Types.CompileTime.NumberParameter;

public class MethodOverloading {
    public MethodOverloading() {
    }

    private static void display(int a) {
        System.out.println("Arguments: " + a);
    }

    private static void display(int a, int b) {
        System.out.println("Arguments: " + a + " and " + b);
    }

    public static void main(String[] args) {
        display(1);
        display(1, 4);
    }
}
