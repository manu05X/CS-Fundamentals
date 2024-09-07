package com.manish.OOP.AccesModifyer.accessmodifiers2;

import com.manish.OOP.AccesModifyer.accessmodifiers1.Student;

public class StudentChild extends Student {
    public StudentChild() {
    }

    void doSomething() {
        this.email = "naman@scaler.com";
    }
}

