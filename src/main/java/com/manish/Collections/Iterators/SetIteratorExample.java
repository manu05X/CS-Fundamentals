package com.manish.Collections.Iterators;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIteratorExample {
    public SetIteratorExample() {
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Date");
        set.add("Elderberry");
        Iterator<String> iterator = set.iterator();
        System.out.println("Traversing the set:");

        while(iterator.hasNext()) {
            System.out.println("Element: " + (String)iterator.next());
        }

    }
}
