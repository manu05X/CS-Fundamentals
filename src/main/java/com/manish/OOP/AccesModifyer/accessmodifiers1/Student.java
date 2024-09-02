package com.manish.OOP.AccesModifyer.accessmodifiers1;


public class Student {
    private String name;
    int age = 10;
    protected String gender;
    public String email;

    void do1() {
        this.name = "Namna";
    }

    public void changeName(String newName) {
        System.out.println("Someone is trying to change the name of student");
        this.name = newName;
    }

    public Student() {
        System.out.println("A CUSTOM CONSTRUCTOR THAT I CREATED");
        this.name = "Naman Bhalla";
        this.age = 24;
    }

    public Student(String name, int age, String gender) {
        System.out.println("CONSTRUCTOR IS STARTINGGGGG");
        this.name = name;
    }
}

