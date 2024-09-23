package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Example2;

// Simple Factory: PizzaFactory class
//Creator Classes : responsible for creating different types of Pizza objects
// The client (PizzaStore) does not directly instantiate the Pizza objects. Instead, it delegates this responsibility to the factory.
public class PizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
