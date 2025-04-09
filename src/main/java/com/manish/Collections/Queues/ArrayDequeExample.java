package com.manish.Collections.Queues;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeExample {
    public ArrayDequeExample() {
    }

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque();
        deque.add("A");
        deque.addFirst("B");
        deque.addLast("C");
        System.out.println("ArrayDeque: " + String.valueOf(deque));
        System.out.println("First element: " + (String)deque.getFirst());
        System.out.println("Last element: " + (String)deque.getLast());
        deque.removeFirst();
        deque.removeLast();
        System.out.println("ArrayDeque after removals: " + String.valueOf(deque));
        System.out.println("Iterating through the array deque:");
        Iterator var2 = deque.iterator();

        while(var2.hasNext()) {
            String element = (String)var2.next();
            System.out.println(element);
        }

    }
}