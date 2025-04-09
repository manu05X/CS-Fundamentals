package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.Communication;

import com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.Communication.SharedResource;

class Producer extends Thread {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for(int i = 0; i < 5; ++i) {
            this.resource.produce();
        }

    }
}