package com.manish.OOD.CreationalDesign.BuilderDesign.Pizza;

// Concrete Builder for Hawaiian Pizza
class HawaiianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("Pan crust");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Tomato sauce");
    }

    @Override
    public void buildToppings() {
        pizza.addTopping("Ham");
        pizza.addTopping("Pineapple");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
