package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

class SharedResource {
    private boolean available = false;

    SharedResource() {
    }

    public synchronized void produce() {
        while(this.available) {
            try {
                this.wait();
            } catch (InterruptedException var2) {
                InterruptedException e = var2;
                e.printStackTrace();
            }
        }

        System.out.println("Produced");
        this.available = true;
        this.notify();
    }

    public synchronized void consume() {
        while(!this.available) {
            try {
                this.wait();
            } catch (InterruptedException var2) {
                InterruptedException e = var2;
                e.printStackTrace();
            }
        }

        System.out.println("Consumed");
        this.available = false;
        this.notify();
    }
}
