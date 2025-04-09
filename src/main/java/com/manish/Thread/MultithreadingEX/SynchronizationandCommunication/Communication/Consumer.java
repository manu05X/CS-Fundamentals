package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.Communication;

import com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.Communication.SharedResource;

public class Consumer extends Thread {
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