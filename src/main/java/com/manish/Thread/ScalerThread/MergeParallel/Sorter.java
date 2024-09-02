package com.manish.Thread.ScalerThread.MergeParallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> values = new ArrayList<>();
    private ExecutorService executorService;

    public Sorter(List<Integer> values, ExecutorService executor) {
        this.values = values;
        this.executorService = executor;

    }

    public List<Integer> call() throws Exception{

        System.out.println("Got " + values + " on thread: " + Thread.currentThread().getName());

        //Base case
        if(values.size() <= 1){
            return values;
        }

        //Split the array
        int mid = values.size()/2;

        List<Integer> leftArray = values.subList(0,mid); // 0 to mid-1
        List<Integer> rightArray = values.subList(mid, values.size()); // mid to size-1
        //now here we have splitted the array

        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);

//        executorService.submit(leftSorter);
//        executorService.submit(rightSorter);
        //we expect a future from our executor

        Future<List<Integer>> leftFutureSorted = executorService.submit(leftSorter);
        Future<List<Integer>>  rightFutureSorted = executorService.submit(rightSorter);

        // Merge the array
        return merge(leftFutureSorted, rightFutureSorted);
    }

    private List<Integer> merge(Future<List<Integer>> sortedLeftFuture, Future<List<Integer>> sortedRightFuture)
            throws InterruptedException, ExecutionException {
        System.out.println("Merging " + values + " on thread: " + Thread.currentThread().getName());

        List<Integer> sortedArray = new ArrayList<>();
        int first = 0;
        int second = 0;

        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight = sortedRightFuture.get();

        // Compare values from both the arrays
        while (first < sortedLeft.size() && second < sortedRight.size()) {
            // If left is smaller, add to sorted array
            // increment first
            if (sortedLeft.get(first) < sortedRight.get(second)) {
                sortedArray.add(sortedLeft.get(first));
                ++first;
            } else {
                // Add the right one to the sorted array
                // increment second
                sortedArray.add(sortedRight.get(second));
                ++second;
            }
        }

        while (first < sortedLeft.size()) {
            sortedArray.add(sortedLeft.get(first));
            ++first;
        }

        while (second < sortedRight.size()) {
            sortedArray.add(sortedRight.get(second));
            ++second;
        }

        return sortedArray;
    }

}

// Parallel - multiple tasks at same time instant
// 7:11 - Task 1
// 7:11 - Task 2

// Person 1 Done
// Person 2 IN PROCESS
// Person 3 NOT started

// Concurrency - Two tasks at different stages of execution
// Person 1 - Intro 10% IN PROCESS
// Person 2 - intro 10% IN PROCESS
// Person 3 - intro 10% IN PROCESS

// Person 1 - Query

