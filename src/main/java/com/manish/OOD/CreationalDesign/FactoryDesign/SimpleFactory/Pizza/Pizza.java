package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Pizza;

// Product: Pizza interface
public interface Pizza {
    public void prepare();
    public void bake();
    public void cut();
    public void box();
}

/*
In this code implementation, we have a Pizza interface that defines the methods that every pizza should have. We also have concrete implementations of Pizza interface such as CheesePizza, PepperoniPizza, and VeggiePizza.
The PizzaFactory class provides a simple factory method createPizza(String type) that takes a type parameter and returns an instance of Pizza based on the input provided by the client.

One of the disadvantages of the Simple Factory pattern is that it violates the Open-Closed Principle. If we need to add a new type of product, we need to modify the factory code, which means we need to recompile and redeploy the code.

 */