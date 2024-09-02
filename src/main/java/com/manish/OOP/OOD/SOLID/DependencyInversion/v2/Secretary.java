package com.manish.OOP.OOD.SOLID.DependencyInversion.v2;

public class Secretary implements Faculty{
    @Override
    public void performDuties() {
        System.out.println("Handling administrative tasks as a secretary");
    }
}
