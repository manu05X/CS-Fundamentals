package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Pizza;

// Concrete Product: PepperoniPizza class
public class PepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing pepperoni pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking pepperoni pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pepperoni pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing pepperoni pizza");
    }
}