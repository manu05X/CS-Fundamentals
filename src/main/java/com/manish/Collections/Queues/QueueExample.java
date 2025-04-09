package com.manish.Collections.Queues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public QueueExample() {
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        System.out.println("Queue: " + String.valueOf(queue));
        System.out.println("Head of queue: " + (String)queue.peek());
        queue.remove();
        System.out.println("Queue after removing an element: " + String.valueOf(queue));
        String polledElement = (String)queue.poll();
        System.out.println("Polled element: " + polledElement);
        System.out.println("Queue after polling an element: " + String.valueOf(queue));
        System.out.println("Iterating through the queue:");
        Iterator var3 = queue.iterator();

        while(var3.hasNext()) {
            String element = (String)var3.next();
            System.out.println(element);
        }

    }
}
