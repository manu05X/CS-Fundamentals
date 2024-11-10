package com.manish.OOP.Polymorphism.Types.RunTime.AccessSpecifier;

public class Cow extends Animal{
    Cow(){

    }

    private void displayPrivate(){
        System.out.println("I am a Cow private.");
    }

    protected void displayCowProtected(){
        System.out.println("I am a Cow Display Protected.");
    }

    public void displayCowPublic(){
        System.out.println("I am a Cow public.");
    }
}
