package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ReadWriteLockExample;

class WriterThread extends Thread {
    private SharedData sharedData;

    public WriterThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for(int i = 0; i < 5; ++i) {
            this.sharedData.writeData(i);

            try {
                Thread.sleep(100L);
            } catch (InterruptedException var3) {
                InterruptedException e = var3;
                e.printStackTrace();
            }
        }

    }
}