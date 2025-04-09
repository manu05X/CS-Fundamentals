package com.manish.Collections.Sets;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
    public TreeSetExample() {
    }

    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        System.out.println("Numbers: " + String.valueOf(numbers));
        System.out.println("First number: " + String.valueOf(numbers.first()));
        System.out.println("Last number: " + String.valueOf(numbers.last()));
        System.out.println("Iterating through the set:");
        Iterator var2 = numbers.iterator();

        while(var2.hasNext()) {
            int number = (Integer)var2.next();
            System.out.println(number);
        }

        numbers.remove(10);
        System.out.println("Numbers after removal: " + String.valueOf(numbers));
    }
}
