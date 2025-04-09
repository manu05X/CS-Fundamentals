package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

import java.util.concurrent.Exchanger;

class Producer extends Thread {
    private Exchanger<String> exchanger;

    public Producer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        String data = "Data from Producer";

        try {
            System.out.println("Producer is exchanging data: " + data);
            data = (String)this.exchanger.exchange(data);
            System.out.println("Producer received: " + data);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

    }
}