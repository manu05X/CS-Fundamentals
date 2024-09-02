package com.manish.OOP.lld.scaler;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// Step 1 - Extend parent class
@Getter
@Setter
public class Mentor extends User {
    private List<Student> mentees = new ArrayList<>();
    private String company;

    public Mentor(String name, String email, List<Student> mentees, String company) {
        super(name, email);
        this.mentees = mentees;
        this.company = company;
    }

}
