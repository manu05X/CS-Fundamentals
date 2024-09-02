package com.manish.Thread.ScalerThread.HundredPrinterPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        //ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        for(int i = 1; i <= 1000; i++)
        {
            if(i == 50)
            {
                System.out.println("Wait Here");
            }

            NumberPrinter obj = new NumberPrinter(i);

            executorService1.execute(obj);

//            Thread t = new Thread(obj);
//            t.start();

        }
    }
}
/*
public class Main {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        //ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10000; ++i) {

            if (i == 50) {
                System.out.println("Wait");
            }

            NumberPrinter numberPrinter = new NumberPrinter(i);
             // this has increased the number of threads of application
             //but at the end the system has same number of core
            if (i % 2 == 0) {
            // if i is even go to pool 2
                executorService2.execute(numberPrinter);
            } else {
                // if i is odd go to pool 1
                executorService1.execute(numberPrinter);
            }

//            Thread t = new Thread(numberPrinter);
//
//            t.start();
        }
    }
}

 */