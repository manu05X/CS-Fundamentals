package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

class ReaderThread extends Thread {
    private SharedData sharedData;

    public ReaderThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for(int i = 0; i < 5; ++i) {
            this.sharedData.readData();

            try {
                Thread.sleep(100L);
            } catch (InterruptedException var3) {
                InterruptedException e = var3;
                e.printStackTrace();
            }
        }

    }
}