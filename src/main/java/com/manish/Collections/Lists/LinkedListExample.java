package com.manish.Collections.Lists;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
    public LinkedListExample() {
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add("Bird");
        System.out.println("LinkedList elements: " + String.valueOf(linkedList));
        String firstElement = (String)linkedList.getFirst();
        String lastElement = (String)linkedList.getLast();
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        linkedList.remove("Cat");
        System.out.println("LinkedList after removing Cat: " + String.valueOf(linkedList));
        System.out.print("Iterating over LinkedList: ");
        Iterator var4 = linkedList.iterator();

        while(var4.hasNext()) {
            String animal = (String)var4.next();
            System.out.print(animal + " ");
        }

    }
}
