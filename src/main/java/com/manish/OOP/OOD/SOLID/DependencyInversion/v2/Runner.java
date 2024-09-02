package com.manish.OOP.OOD.SOLID.DependencyInversion.v2;

public class Runner {
    public static void main(String[] args){
        // Instantiate high-level module and add different low-level modules
        Headmaster headmaster = new Headmaster();

        headmaster.addFaculty(new Secretary());
        headmaster.addFaculty(new Teacher());
        headmaster.addFaculty(new Assistant());
        headmaster.addFaculty(new Helper());

        // High-level module can manage different faculty members without modification
        headmaster.manageSchool();
    }
}
