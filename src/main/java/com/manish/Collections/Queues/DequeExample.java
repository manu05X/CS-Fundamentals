package com.manish.Collections.Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeExample {
    public DequeExample() {
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("Deque: " + String.valueOf(deque));
        System.out.println("First element: " + String.valueOf(deque.getFirst()));
        System.out.println("Last element: " + String.valueOf(deque.getLast()));
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removals: " + String.valueOf(deque));
        System.out.println("Iterating through the deque:");
        Iterator var2 = deque.iterator();

        while(var2.hasNext()) {
            Integer element = (Integer)var2.next();
            System.out.println(element);
        }

    }
}
