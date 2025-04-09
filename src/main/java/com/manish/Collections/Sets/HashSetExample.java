package com.manish.Collections.Sets;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public HashSetExample() {
    }

    public static void main(String[] args) {
        HashSet<String> countries = new HashSet();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Mexico");
        System.out.println("Countries: " + String.valueOf(countries));
        if (countries.contains("Canada")) {
            System.out.println("Canada is in the set.");
        }

        System.out.println("Iterating through the set:");
        Iterator var2 = countries.iterator();

        while(var2.hasNext()) {
            String country = (String)var2.next();
            System.out.println(country);
        }

        countries.remove("Mexico");
        System.out.println("Countries after removal: " + String.valueOf(countries));
    }
}
