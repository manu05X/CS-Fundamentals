package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ExchangerExample;

import java.util.concurrent.Exchanger;

class Consumer extends Thread {
    private Exchanger<String> exchanger; // Exchanger for String objects

    public Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        String data = "Data from Consumer"; // Data to be exchanged

        try {
            System.out.println("Consumer is exchanging data: " + data);
            // Exchange data with producer (blocks until producer is ready)
            data = (String)this.exchanger.exchange(data);
            System.out.println("Consumer received: " + data);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }
    }
}