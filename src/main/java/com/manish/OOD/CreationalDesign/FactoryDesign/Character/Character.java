package com.manish.OOD.CreationalDesign.FactoryDesign.Character;

// Abstract base class for all character types
public abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected int agility;
    protected int intelligence;

    // Constructor to initialize common character attributes
    public Character(String name, int health, int strength, int agility, int intelligence) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    // Abstract method to display character info
    public abstract void display();

    // Abstract method for character-specific attack behavior
    public abstract void attack();
}


