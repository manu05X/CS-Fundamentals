package com.manish.Collections.Sets;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
    public NavigableSetExample() {
    }

    public static void main(String[] args) {
        NavigableSet<String> words = new TreeSet();
        words.add("Apple");
        words.add("Banana");
        words.add("Cherry");
        words.add("Date");
        System.out.println("Words: " + String.valueOf(words));
        System.out.println("First word: " + (String)words.first());
        System.out.println("Last word: " + (String)words.last());
        System.out.println("Lower than 'Banana': " + (String)words.lower("Banana"));
        System.out.println("Higher than 'Banana': " + (String)words.higher("Banana"));
        System.out.println("Iterating through the set:");
        Iterator var2 = words.iterator();

        while(var2.hasNext()) {
            String word = (String)var2.next();
            System.out.println(word);
        }

        words.remove("Date");
        System.out.println("Words after removal: " + String.valueOf(words));
    }
}
