package com.manish.OOD.CreationalDesign.BuilderDesign.Pizza;

// Driver Class
public class Main {
    public static void main(String[] args) {
        // Create a director
        Chef chef = new Chef();

        // Create a specific builder (e.g., Hawaiian Pizza)
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();

        // Set the builder for the director
        chef.setPizzaBuilder(hawaiianPizzaBuilder);

        // Construct the pizza
        chef.constructPizza();

        // Get the constructed pizza
        Pizza hawaiianPizza = chef.getPizza();

        // Output details of the Hawaiian pizza
        System.out.println("Hawaiian Pizza Details:");
        System.out.println("Dough: " + hawaiianPizza.getDough()); // Dough: Pan crust
        System.out.println("Sauce: " + hawaiianPizza.getSauce()); // Sauce: Tomato sauce
        System.out.println("Toppings: " + hawaiianPizza.getToppings()); // Toppings: [Ham, Pineapple]

        // Example of building another pizza (Spicy Pizza)
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();
        chef.setPizzaBuilder(spicyPizzaBuilder);
        chef.constructPizza();
        Pizza spicyPizza = chef.getPizza();

        // Output details of the Spicy pizza
        System.out.println("\nSpicy Pizza Details:");
        System.out.println("Dough: " + spicyPizza.getDough()); // Dough: Thin crust
        System.out.println("Sauce: " + spicyPizza.getSauce()); // Sauce: Hot sauce
        System.out.println("Toppings: " + spicyPizza.getToppings()); // Toppings: [Pepperoni, Chili peppers]
    }
}

/*
Key Components
1> Builder: This is an interface or an abstract class that defines the steps required to construct a product.
2> Concrete Builders: These are classes that implement the Builder interface and provide specific implementations for constructing the product.
3> Product: This is the complex object that is being constructed.
4> Director (optional): This is an optional class that oversees the construction process and coordinates the builders to construct the final product.
 */