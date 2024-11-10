package com.manish.OOP.Polymorphism.Types.RunTime.AccessSpecifier;

public class Main {
    Main() {
    }

    public static void main(String[] args) {
//        Dog d1 = new Dog();
//        d1.displayInfo();

        Cow cow1 = new Cow();
        cow1.displayInfo();
        cow1.displayCowPublic();
        //cow1.displayPrivate(); // private cannot be called
        cow1.displayCowProtected();

        Animal cow2 = new Cow();
        cow2.displayInfo();
    }
}
