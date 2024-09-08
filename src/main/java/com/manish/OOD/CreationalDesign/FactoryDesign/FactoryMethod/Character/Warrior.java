package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Character;

// Concrete Warrior class
public class Warrior extends Character {
    public Warrior(String name, int health, int strength, int agility, int intelligence) {
        super(name, health, strength, agility, intelligence);
    }

    @Override
    public void display() {
        System.out.println("I am a warrior named " + name + ".");
    }

    @Override
    public void attack() {
        System.out.println("I swing my sword!");
    }
}
