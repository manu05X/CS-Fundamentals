package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ExchangerExample;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public ExchangerExample() {
    }

    public static void main(String[] args) {
        // Create an Exchanger for String objects
        Exchanger<String> exchanger = new Exchanger<>();

        // Create producer and consumer threads sharing the same exchanger
        Producer producer = new Producer(exchanger);
        Consumer consumer = new Consumer(exchanger);

        // Start both threads
        producer.start();
        consumer.start();

        try {
            // Wait for both threads to complete
            producer.join();
            consumer.join();
        } catch (InterruptedException var5) {
            InterruptedException e = var5;
            e.printStackTrace();
        }
    }
}

/*
What is an Exchanger?
An Exchanger is a synchronization point where two threads can exchange objects between each other. It provides a simple way for threads to swap data in a thread-safe manner without explicit synchronization.

Key Characteristics:
    Allows two threads to meet and exchange data at a synchronization point
    Blocks until both threads reach the exchange point
    Useful for producer-consumer patterns where both threads need to exchange data
    Each thread provides an object when calling exchange() and receives the other thread's object



Key Points About Exchanger
    Synchronization Point: Both threads must reach the exchange point for the transfer to occur
    Data Safety: Provides thread-safe data exchange without manual synchronization

Use Cases:
    Genetic algorithms (exchanging chromosomes)
    Pipeline processing between threads
    Peer-to-peer communication between threads
    Timeout Option: Can use exchange(V x, long timeout, TimeUnit unit) for timed waits
    Single Use: Typically used for one-time exchange between pairs of threads


 */