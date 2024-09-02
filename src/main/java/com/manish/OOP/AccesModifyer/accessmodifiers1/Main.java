package com.manish.OOP.AccesModifyer.accessmodifiers1;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.age = 12;
        student.gender = "Male";
        student.email = "naman@scaler.com";
        student.changeName("Rohit");
        new Student("Naman", 24, "Male");
    }
}
