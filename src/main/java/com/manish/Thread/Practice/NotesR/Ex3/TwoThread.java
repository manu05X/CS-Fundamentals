package com.manish.Thread.Practice.NotesR.Ex3;



public class TwoThread {
    public static void main(String[] args) {


        int x = 0; //
        // int[] arr = new int[10]; //

        Thread t1 = new Thread(); // one thread
        t1.start();
        Thread[] arr = new Thread[10]; // 10 Thread array

        for(int i = 1; i <= 10; i++){
            //System.out.println("Thread Number : "+ i);
            arr[i-1] = new Thread(() -> {
                System.out.println("Running Thread 1");
            });

            arr[i-1].start();
        }
    }
}
// 1,2,3,4,