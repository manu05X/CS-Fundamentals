package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

class SharedData {
    private boolean ready = false;

    SharedData() {
    }

    public synchronized void produce() {
        this.ready = true;
        System.out.println("Produced data");
        this.notifyAll();
    }

    public synchronized void consume() {
        while(!this.ready) {
            try {
                this.wait();
            } catch (InterruptedException var2) {
                InterruptedException e = var2;
                e.printStackTrace();
            }
        }

        System.out.println("Consumed data");
    }
}
