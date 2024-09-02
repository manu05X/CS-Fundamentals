package com.manish.OOP.OOD.SOLID.DependencyInversion.v0;

public class Headmaster {
    private Teacher teacher;
    private Assistant assistant;
    private Helper helper;

    public Headmaster() {
        this.teacher = new Teacher();
        this.assistant = new Assistant();
        this.helper = new Helper();
    }

    public void manageSchool() {
        teacher.teach();
        assistant.assist();
        helper.help();
        System.out.println("Managing overall school operations");
    }
}
