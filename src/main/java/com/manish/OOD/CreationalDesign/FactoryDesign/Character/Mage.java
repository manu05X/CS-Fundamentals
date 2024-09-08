package com.manish.OOD.CreationalDesign.FactoryDesign.Character;

// Concrete Mage class
public class Mage extends Character {
    public Mage(String name, int health, int strength, int agility, int intelligence) {
        super(name, health, strength, agility, intelligence);
    }

    @Override
    public void display() {
        System.out.println("I am a mage named " + name + ".");
    }

    @Override
    public void attack() {
        System.out.println("I cast a spell!");
    }
}
