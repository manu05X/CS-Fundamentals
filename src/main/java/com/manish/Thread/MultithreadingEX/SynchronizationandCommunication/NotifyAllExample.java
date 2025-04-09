package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

import java.util.Objects;

public class NotifyAllExample {
    public NotifyAllExample() {
    }

    public static void main(String[] args) {
        SharedData data = new SharedData();
        Objects.requireNonNull(data);
        Thread consumer1 = new Thread(data::consume);
        Objects.requireNonNull(data);
        Thread consumer2 = new Thread(data::consume);
        Objects.requireNonNull(data);
        Thread producer = new Thread(data::produce);
        consumer1.start();
        consumer2.start();
        producer.start();
    }
}