package com.manish.Collections.Iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public ListIteratorExample() {
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListIterator<Integer> iterator = list.listIterator();
        System.out.println("Traversing the list in forward direction:");

        while(iterator.hasNext()) {
            System.out.println("Element: " + String.valueOf(iterator.next()));
        }

        System.out.println("Traversing the list in backward direction:");

        while(iterator.hasPrevious()) {
            System.out.println("Element: " + String.valueOf(iterator.previous()));
        }

    }
}
