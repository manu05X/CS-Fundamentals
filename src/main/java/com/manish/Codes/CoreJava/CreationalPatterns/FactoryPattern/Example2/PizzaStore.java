package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Example2;

// Client: PizzaStore class
// Concrete Creator Classes :
public class PizzaStore {
    PizzaFactory pizzaFactory;

    public PizzaStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

/*
The PizzaStore class interacts with the Pizza interface and uses it without knowing the exact concrete class
(CheesePizza, PepperoniPizza, or VeggiePizza) that is created.
This makes the code flexible and easier to extend if new types of pizzas are added.

For example, if a new type of pizza like MargheritaPizza is introduced, the PizzaFactory can be updated
to create this new pizza without changing the PizzaStore or how orderPizza is called.

 */