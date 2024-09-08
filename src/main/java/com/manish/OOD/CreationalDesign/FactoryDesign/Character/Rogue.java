package com.manish.OOD.CreationalDesign.FactoryDesign.Character;

// Concrete Rogue class
public class Rogue extends Character {
    public Rogue(String name, int health, int strength, int agility, int intelligence) {
        super(name, health, strength, agility, intelligence);
    }

    @Override
    public void display() {
        System.out.println("I am a rogue named " + name + ".");
    }

    @Override
    public void attack() {
        System.out.println("I strike from the shadows!");
    }
}
