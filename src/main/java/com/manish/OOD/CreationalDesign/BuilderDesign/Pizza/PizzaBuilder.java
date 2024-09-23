package com.manish.OOD.CreationalDesign.BuilderDesign.Pizza;

// Builder Interface
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildToppings();
    Pizza getPizza();
}
