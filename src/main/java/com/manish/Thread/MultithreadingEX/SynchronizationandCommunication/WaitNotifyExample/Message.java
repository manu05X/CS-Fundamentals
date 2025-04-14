package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.WaitNotifyExample;

//class Message {
//    private String message;
//
//    Message() {
//    }
//
//    public synchronized void produce(String message) {
//        this.message = message;
//        System.out.println("Produced: " + message);
//        this.notify();
//    }
//
//    public synchronized void consume() {
//        try {
//            this.wait();
//        } catch (InterruptedException var2) {
//            InterruptedException e = var2;
//            e.printStackTrace();
//        }
//
//        System.out.println("Consumed: " + this.message);
//    }
//}


public class Message {
    private String message;
    private boolean empty = true;

    public synchronized void produce(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.message = message;
        empty = false;
        System.out.println("Producer produced: " + message);
        notifyAll();
    }

    public synchronized String consume() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        System.out.println("Consumer consumed: " + message);
        notifyAll();
        return message;
    }
}