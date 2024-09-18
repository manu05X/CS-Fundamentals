package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.GUIFactory;

// Concrete Product for Linux Button
public class LinuxButton implements Button {
    public void paint() {
        System.out.println("Painting a Linux button.");
    }
}
