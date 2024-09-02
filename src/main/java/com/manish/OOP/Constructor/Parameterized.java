package com.manish.OOP.Constructor;

public class Parameterized {
    private String name;

    public Parameterized(String n) {
        System.out.println("Inside Parameterized main.Constructor");
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Parameterized obj = new Parameterized("Java");
        System.out.println(obj.getName());
    }
}
