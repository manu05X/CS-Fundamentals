package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Vehical;

// Concrete Products
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}
