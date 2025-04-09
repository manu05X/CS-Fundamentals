package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.WaitNotifyExample;

class Message {
    private String message;

    Message() {
    }

    public synchronized void produce(String message) {
        this.message = message;
        System.out.println("Produced: " + message);
        this.notify();
    }

    public synchronized void consume() {
        try {
            this.wait();
        } catch (InterruptedException var2) {
            InterruptedException e = var2;
            e.printStackTrace();
        }

        System.out.println("Consumed: " + this.message);
    }
}