package com.manish.Collections.Queues;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public PriorityQueueExample() {
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(5);
        System.out.println("PriorityQueue: " + String.valueOf(priorityQueue));
        System.out.println("Head of queue: " + String.valueOf(priorityQueue.peek()));
        priorityQueue.poll();
        System.out.println("PriorityQueue after polling: " + String.valueOf(priorityQueue));
        System.out.println("Iterating through the priority queue:");
        Iterator var2 = priorityQueue.iterator();

        while(var2.hasNext()) {
            Integer element = (Integer)var2.next();
            System.out.println(element);
        }

    }
}
