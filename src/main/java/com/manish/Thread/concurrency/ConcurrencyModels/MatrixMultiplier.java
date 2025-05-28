package com.manish.Thread.concurrency.ConcurrencyModels;

/*

public class MatrixMultiplier {
    public static int[][] multiply(int[][] A, int[][] B){
        int n = A.length;
        int[][] C = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

}

 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixMultiplier {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    public static int[][] multiply(int[][] A, int[][] B) throws Exception {
        int n = A.length;
        int[][] C = new int[n][n];

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Future<?>[] futures = new Future[n];


        for(int i = 0; i < n; i++){
            final int row = i;
            futures[i] = executorService.submit(() -> {
                for(int j = 0; j < n; j++){
                    for(int k = 0; k < n; k++){
                        C[row][j] += A[row][k] * B[k][j];
                    }
                }
            });

        }

        for (Future<?> future : futures){
            future.get();
        }

        executorService.shutdown();

        return C;
    }

}
