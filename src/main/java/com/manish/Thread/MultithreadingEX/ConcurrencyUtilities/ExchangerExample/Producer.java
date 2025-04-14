package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ExchangerExample;

import java.util.concurrent.Exchanger;

class Producer extends Thread {
    private Exchanger<String> exchanger; // Exchanger for String objects

    public Producer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        String data = "Data from Producer"; // Data to be exchanged

        try {
            System.out.println("Producer is exchanging data: " + data);
            // Exchange data with consumer (blocks until consumer is ready)
            data = (String)this.exchanger.exchange(data);
            System.out.println("Producer received: " + data);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }
    }
}