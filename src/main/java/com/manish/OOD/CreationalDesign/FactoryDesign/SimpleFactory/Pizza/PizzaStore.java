package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Pizza;

// Client: PizzaStore class
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

    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(pizzaFactory);

        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("pepperoni");
        pizzaStore.orderPizza("veggie");
    }
}


/*
Key Components
Product Interface (Pizza): The Pizza interface defines common methods (prepare(), bake(), cut(), box()) that all pizza types (products) must implement.

Concrete Products (CheesePizza, PepperoniPizza, VeggiePizza): These classes implement the Pizza interface. Each concrete class provides specific implementations of the prepare(), bake(), cut(), and box() methods. Each type represents a different product (pizza).

Simple Factory (PizzaFactory): The PizzaFactory class has a method createPizza(String type) that is responsible for creating the appropriate Pizza object based on the input type. The factory handles the creation logic, which keeps the client (PizzaStore) from needing to know the details of how each specific pizza is created.

Client (PizzaStore): The PizzaStore depends on the PizzaFactory to create pizzas. Instead of the PizzaStore directly instantiating a CheesePizza, PepperoniPizza, or VeggiePizza, it asks the PizzaFactory to create the right pizza by calling pizzaFactory.createPizza(type). This decouples the client from the actual instantiation logic, making the code more flexible and easier to maintain.

How the Factory Design Pattern is Applied
Decoupling object creation: The factory pattern moves the creation of Pizza objects from the client (PizzaStore) to the PizzaFactory. This allows the PizzaStore to focus on business logic (preparing, baking, cutting, and boxing the pizza) without worrying about the specifics of pizza creation.

Single Responsibility Principle: The PizzaStore delegates the responsibility of pizza creation to the PizzaFactory. This keeps the PizzaStore from having too many responsibilities, adhering to clean design principles.

Flexibility and Extensibility: If new types of pizzas are introduced (e.g., ClamPizza or BBQPizza), you only need to modify the PizzaFactory class to handle the new types. The PizzaStore doesn’t need to change at all.
 */