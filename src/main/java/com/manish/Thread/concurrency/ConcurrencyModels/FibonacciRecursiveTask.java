package com.manish.Thread.concurrency.ConcurrencyModels;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork(); // Start asynchronously

        Fibonacci f2 = new Fibonacci(n - 2);
        int result = f2.compute() + f1.join(); // Wait for f1 to complete

        return result;
    }
}

public class FibonacciRecursiveTask {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        int result = pool.invoke(new Fibonacci(10));

        System.out.println(result);
    }
}

