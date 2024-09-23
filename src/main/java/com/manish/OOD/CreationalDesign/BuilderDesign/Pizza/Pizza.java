package com.manish.OOD.CreationalDesign.BuilderDesign.Pizza;

import java.util.ArrayList;
import java.util.List;

// Product Class
public class Pizza {
    private String dough;
    private String sauce;
    private List<String> toppings;

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    // Getters for outputting pizza details
    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }
}

