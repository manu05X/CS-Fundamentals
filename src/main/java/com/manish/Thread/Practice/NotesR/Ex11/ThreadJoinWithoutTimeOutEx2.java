package com.manish.Thread.Practice.NotesR.Ex11;

public class ThreadJoinWithoutTimeOutEx2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("Thread-1 is running....");
            try{
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-1 is finished !");
        });

        Thread t2 = new Thread(()->{
            System.out.println("Thread-2 is running....");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-2 is finished !");
        });

        t1.start();;
        t2.start();

        try {
            t1.join();;
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Both Thread-1 and Thread-2 is finished !");
    }
}
