package com.manish.Collections.Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastIteratorExample {
    public FailFastIteratorExample() {
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        System.out.println("Traversing the list:");

        while(iterator.hasNext()) {
            System.out.println("Element: " + String.valueOf(iterator.next()));
            if ((Integer)iterator.next() == 3) {
                list.add(6);
            }
        }

    }
}
