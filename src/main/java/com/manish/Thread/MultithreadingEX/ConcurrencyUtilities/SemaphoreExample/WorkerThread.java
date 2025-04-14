package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.SemaphoreExample;

class WorkerThread extends Thread {
    private SharedResource resource;

    public WorkerThread(SharedResource resource, String name) {
        super(name); // Set thread name
        this.resource = resource;
    }

    public void run() {
        // Each thread tries to access the shared resource
        this.resource.accessResource(this.getName());
    }
}