package com.manish.OOP.Constructor.Super;

public class Student extends Person {
    private String name;

    public Student() {
        System.out.println("Student Created");
    }

    public Student(int i, String n) {
        super(i); // super class constructor called
        this.name = n;
        System.out.println("Student Created with name = " + n);
    }
    public static void main(String[] args) {
        Student st = new Student();
        Student obj = new Student(21, "Virat");
    }
}