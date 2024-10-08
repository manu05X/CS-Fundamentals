package com.manish.Thread.JavaConcurrencyReference.B.JavaMultiThreading.JavaConcurrencyReference.B.CInterruptingThread;

public class HelloWorld {
    public static void main( String args[] ) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.start();

        // Interrupt innerThread after waiting for 5 seconds
        System.out.println("com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main thread sleeping at " + +System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        innerThread.interrupt();
        System.out.println("com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main thread exiting at " + +System.currentTimeMillis() / 1000);
    }

    static class ExecuteMe implements Runnable {

        public void run() {
            try {
                // sleep for a thousand minutes
                System.out.println("innerThread goes to sleep at " + System.currentTimeMillis() / 1000);
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException ie) {
                System.out.println("innerThread interrupted at " + +System.currentTimeMillis() / 1000);
            }
        }
    }

}