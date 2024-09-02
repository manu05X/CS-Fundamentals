package com.manish.OOP.Constructor.Super;

public class Person {

    private int age;

    public Person() {
        System.out.println("Person Created");
    }

    public Person(int i) {
        this.age = i;
        System.out.println("Person Created with Age = " + i);
    }

}
