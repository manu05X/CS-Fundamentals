package com.manish.Thread.JavaConcurrencyReference.B.BSleepingThread;

public class SleepThreadExample {
    public static void main(String args[]) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.start();
        innerThread.join();
        System.out.println("Main thread exiting.");
    }

    static class ExecuteMe implements Runnable {

        public void run() {
            System.out.println("Hello. innerThread going to sleep");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                // swallow interrupted exception
            }
        }
    }
}
/*
In the above example, the innerThread is made to sleep for 1 second and from the output of the program, one can see that main thread exits only after innerThread is done processing.
If we remove the join statement on line-6, then the main thread may print its statement before innerThread is done executing.


* */