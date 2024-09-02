package com.manish.OOP.OOD.SOLID.birdExample;
public abstract class Bird {
    private Integer weight;
    private String color;
    private String size;
    private String beakType;
    private BirdType type;

    public Bird(Integer weight, String colour, String size, String beakType, BirdType type ) {
        this.weight = weight;
        this.color = colour;
        this.size = size;
        this.beakType = beakType;
        this.type = type;
    }

    public BirdType getType(){
        return type;
    }

    public abstract void makeSound();
}
