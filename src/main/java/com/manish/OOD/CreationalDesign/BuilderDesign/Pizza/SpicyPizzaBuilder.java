package com.manish.OOD.CreationalDesign.BuilderDesign.Pizza;

// Concrete Builder for Spicy Pizza (Example of another pizza type)
class SpicyPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public SpicyPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("Thin crust");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Hot sauce");
    }

    @Override
    public void buildToppings() {
        pizza.addTopping("Pepperoni");
        pizza.addTopping("Chili peppers");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
