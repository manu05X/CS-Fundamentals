package com.manish.Collections.Lists;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorExample {
    public ListIteratorExample() {
    }

    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        ListIterator<String> iterator = cities.listIterator();
        System.out.println("Forward iteration:");

        while(iterator.hasNext()) {
            System.out.println((String)iterator.next());
        }

        System.out.println("Backward iteration:");

        while(iterator.hasPrevious()) {
            System.out.println((String)iterator.previous());
        }

        System.out.println("Modifying elements:");

        while(iterator.hasNext()) {
            String city = (String)iterator.next();
            if (city.equals("Chicago")) {
                iterator.set("San Francisco");
            }
        }

        System.out.println("Cities after modification: " + String.valueOf(cities));
    }
}
