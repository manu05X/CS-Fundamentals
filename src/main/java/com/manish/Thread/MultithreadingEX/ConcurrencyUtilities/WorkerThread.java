package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

class WorkerThread extends Thread {
    private SharedResource resource;

    public WorkerThread(SharedResource resource, String name) {
        super(name);
        this.resource = resource;
    }

    public void run() {
        this.resource.accessResource(this.getName());
    }
}