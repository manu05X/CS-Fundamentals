package com.manish.OOP.OOD.SOLID.DependencyInversion.v2;

public class Teacher implements Faculty{
    @Override
    public void performDuties() {
        System.out.println("Teaching students");
    }
}
