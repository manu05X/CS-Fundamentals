package com.manish.OOP.OOD.SOLID.DependencyInversion.v2;

import java.util.ArrayList;
import java.util.List;

public class Headmaster {
    private List<Faculty> facultyList;

    public Headmaster(){
        this.facultyList = new ArrayList<>();
    }

    // Method to add faculty members
    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    // Method to manage the school and delegate tasks to faculty
    public void manageSchool() {
        for (Faculty faculty : facultyList) {
            faculty.performDuties();
        }
    }

}
