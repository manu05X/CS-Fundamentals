package com.manish.OOD.StructuralDesign.Flyweight.Example1;

// ConcreteFlyweight class implements the Flyweight interface
public class ConcreteFlyweight implements Flyweight {
    private final String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
    }

    @Override
    public void operation() {
        System.out.println("ConcreteFlyweight with key " + key + " is executing.");
    }
}
