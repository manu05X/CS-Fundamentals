package com.manish.Thread.ScalerThread.HundredPrinter;

public class Main {
    public static void main(String[] args) {
        for(int i = 1; i <= 1000; i++){
            //1. Create instance of the task-->car
            // task is equivalent to car in a lane
            NumberPrinter obj = new NumberPrinter(i);
            //While using static variable in NumberPrinter class
            //NumberPrinter obj = new NumberPrinter();

            //2. Create the instance/obj of thread/lane and
            // put the task/car in the obj of task/car in the thread/lane
            Thread t = new Thread(obj);
            //// 3. Start the thread (it just tells the cpu that I want to run this thread)
            t.start();

        }
    }
}
