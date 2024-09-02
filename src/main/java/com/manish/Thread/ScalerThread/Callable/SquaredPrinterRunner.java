package com.manish.Thread.ScalerThread.Callable;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/*

*/
public class SquaredPrinterRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Create a list of values
        //List.of(1,2,3,4,5) initializes array/list very easily
        List<Integer> values = List.of(1,2,3,4,5);

        //Here using executerService that create and start the thread
        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.println(Thread.currentThread().getName());

        List<Future<Integer>> results = new ArrayList<>();
        //Iterate over the list and create a thread
        for(Integer value:values){
            //creating object of callable SquareGenerator
            SquareGenerator obj = new SquareGenerator(value);

            // passing the obj of callable in submit and submit mwthod will internally call the call() method of callable interface
            // it will return future to us that we will store in separate array results
            Future<Integer> future = executor.submit(obj);

            System.out.println("AS soon it is submitted : " + future.isDone());
            //here future is a promise
            results.add(future);
        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Thread.sleep(1000);

//        for(Future<Integer> future : results){
//                System.out.println("The square of value is : "+ future.get());
//        }

        for(Future<Integer> future : results){
            System.out.println(future.isDone());
            System.out.println("The square of value is : " + future.get()); // get is blocking IO's
            System.out.println("Square Computed");
        }


    }
}
/*
Future are the container for asyncronus container

* */
