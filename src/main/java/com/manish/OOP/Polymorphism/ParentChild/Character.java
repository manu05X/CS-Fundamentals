package com.manish.OOP.Polymorphism.ParentChild;

public class Character {
    private int hp;
    protected String type;
    Character(){
        type = "Character";
    }
    public void defend(){
        System.out.println( type + " defends " );
    }
    public void attack(Character other) {

        System.out.println( type + " attacks " + other.type );
    }
}
