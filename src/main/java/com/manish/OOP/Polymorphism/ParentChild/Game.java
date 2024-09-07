package com.manish.OOP.Polymorphism.ParentChild;

import java.util.ArrayList;

//public class Game {
//}
public class Game {
    public static void main(String args[ ]) {

        /* Setting up the ArrayList */

        ArrayList<Character> characters = new ArrayList<Character>();

        characters.add(new Swordsman());
        characters.add(new Magician());
        characters.add(new Slime());
        characters.add(new Globin());

        /* Accessing each element in the ArrayList invidually with get */

        characters.get(0).defend();
        characters.get(1).attack(characters.get(3));
        characters.get(2).attack(characters.get(0)); // Note that Slime does not have its special type.

        /* Looping over the ArrayList regardless of their individual child class */

        for(Character character: characters) {
            character.defend();
        }

    }
}
