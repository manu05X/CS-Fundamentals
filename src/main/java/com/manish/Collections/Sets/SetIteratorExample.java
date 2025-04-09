package com.manish.Collections.Sets;

import java.util.HashSet;
import java.util.Iterator;

public class SetIteratorExample {
    public SetIteratorExample() {
    }

    public static void main(String[] args) {
        HashSet<String> animals = new HashSet();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        Iterator<String> iterator = animals.iterator();
        System.out.println("Iterating through the set:");

        while(iterator.hasNext()) {
            System.out.println((String)iterator.next());
        }

        iterator = animals.iterator();

        while(iterator.hasNext()) {
            String animal = (String)iterator.next();
            if (animal.equals("Cat")) {
                iterator.remove();
            }
        }

        System.out.println("Animals after removal: " + String.valueOf(animals));
    }
}
