package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.Communication;

class SharedResource {
    // Flag to indicate if a new item is available
    private boolean available = false;

    public synchronized void produce() {
        // Wait while item is still available (not consumed yet)
        while(this.available) {
            try {
                this.wait();  // Releases lock and waits for notification
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Produced");
        this.available = true;  // Mark as produced
        this.notify();  // Notify waiting consumer
    }

    public synchronized void consume() {
        // Wait while no item is available
        while(!this.available) {
            try {
                this.wait();  // Releases lock and waits for notification
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Consumed");
        this.available = false;  // Mark as consumed
        this.notify();  // Notify waiting producer
    }
}