package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

class Consumer extends Thread {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for(int i = 0; i < 5; ++i) {
            this.resource.consume();
        }

    }
}