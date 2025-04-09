package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

public class ThreadCommunicationExample {
    public ThreadCommunicationExample() {
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
    }
}