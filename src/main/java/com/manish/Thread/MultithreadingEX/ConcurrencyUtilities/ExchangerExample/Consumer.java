package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ExchangerExample;

import java.util.concurrent.Exchanger;

class Consumer extends Thread {
    private Exchanger<String> exchanger;

    public Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        String data = "Data from Consumer";

        try {
            System.out.println("Consumer is exchanging data: " + data);
            data = (String)this.exchanger.exchange(data);
            System.out.println("Consumer received: " + data);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

    }
}