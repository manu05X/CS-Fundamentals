package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

public class ReadWriteLockExample {
    public ReadWriteLockExample() {
    }

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        ReaderThread reader1 = new ReaderThread(sharedData);
        ReaderThread reader2 = new ReaderThread(sharedData);
        WriterThread writer = new WriterThread(sharedData);
        reader1.start();
        reader2.start();
        writer.start();

        try {
            reader1.join();
            reader2.join();
            writer.join();
        } catch (InterruptedException var6) {
            InterruptedException e = var6;
            e.printStackTrace();
        }

    }
}