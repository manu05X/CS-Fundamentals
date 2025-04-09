package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.WaitNotifyExample;


public class WaitNotifyExample {
    public WaitNotifyExample() {
    }

    public static void main(String[] args) {
        Message msg = new Message();
        Thread producer = new Thread(() -> {
            msg.produce("Hello, World!");
        });
        Thread consumer = new Thread(() -> {
            msg.consume();
        });
        consumer.start();
        producer.start();
    }
}