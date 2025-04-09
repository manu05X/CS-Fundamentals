package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ExchangerExample;


import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public ExchangerExample() {
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        Producer producer = new Producer(exchanger);
        Consumer consumer = new Consumer(exchanger);
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException var5) {
            InterruptedException e = var5;
            e.printStackTrace();
        }

    }
}