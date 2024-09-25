package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.Pizza;

public class Main {
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



/*
1> Pizza Store         2> Pizza Factory (Kitchen)

Way to order a pizza.
1> We go to store and order the pizza of desire type . [ pizzaStore.orderPizza("cheese");]
2> The waiter will take the order and go to kitchen i.e to chef.[PizzaStore(pizzaFactory);]
3> Chef will check if the type matches with the availability type . [if (type.equals("cheese"))]
4> Now if match is correct it is created in the oven. [created in the constructor of concrete class[CheesePizza] i.e  pizza = new CheesePizza();]
5> This is return to waiter. [return pizza form factory class to store]
6> The waiter will bring the order to your table. [return pizza form store to main and i.e output on cli]



Summary:
Creator Class: PizzaFactory
Concrete Creator Class: PizzaStore
Product Interface: Pizza
Concrete Product Classes: CheesePizza, PepperoniPizza, VeggiePizza



Starts the program.
1> Creates a PizzaFactory object.
2> Creates a PizzaStore object, passing the PizzaFactory object to its constructor.
3> Calls the orderPizza method of PizzaStore.



1> Justifying the Factory Design Pattern:
The Factory Design Pattern is defined as:
A design pattern that provides a way to encapsulate the object creation process, allowing a client to request objects without knowing the exact class to instantiate.

In your code, this definition is clearly justified as follows:

1> Encapsulation of Object Creation:
    - The PizzaFactory class is solely responsible for creating different types of Pizza objects. It encapsulates the decision of which specific subclass (CheesePizza, PepperoniPizza, VeggiePizza) to instantiate based on the input type.
    - The client (PizzaStore) does not directly instantiate the Pizza objects. Instead, it delegates this responsibility to the factory.

2> Client Doesn't Know the Concrete Class:
    - The PizzaStore class interacts with the Pizza interface and uses it without knowing the exact concrete class (CheesePizza, PepperoniPizza, or VeggiePizza) that is created. This makes the code flexible and easier to extend if new types of pizzas are added.
    - For example, if a new type of pizza like MargheritaPizza is introduced, the PizzaFactory can be updated to create this new pizza without changing the PizzaStore or how orderPizza is called.
3> Flexibility:
    - The PizzaFactory can decide which concrete class to return based on various factors (in this case, the pizza type string), providing flexibility.
    - The client is decoupled from the specific pizza creation logic, allowing easier maintenance and the potential for more sophisti



Flow of the Code (from main):
1> Execution starts in the main method of the PizzaStore class:
    - A PizzaFactory object is created.
    - A PizzaStore object is instantiated using the PizzaFactory as a dependency.
    - The orderPizza() method is called three times with the pizza types "cheese", "pepperoni", and "veggie".

2> Flow of orderPizza() method:
    - When orderPizza("cheese") is called:
        - The PizzaStore object delegates the pizza creation to the PizzaFactory.
        - PizzaFactory.createPizza("cheese") is called, and the factory checks the type and creates a CheesePizza object.
        - The created CheesePizza object is returned to the PizzaStore.
        - The PizzaStore then calls methods on the CheesePizza object: prepare(), bake(), cut(), and box(), which prints the corresponding pizza preparation steps.
    - Similarly, the same steps are repeated for orderPizza("pepperoni") and orderPizza("veggie"), with the factory creating the corresponding PepperoniPizza and VeggiePizza objects.

Completion of the flow:
    After executing the three orderPizza() calls, each type of pizza has been created and processed, and the steps for preparation, baking, cutting, and boxing have been printed.

 */