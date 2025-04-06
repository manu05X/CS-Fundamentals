package com.manish.LLD.ThreadPool.Type2;

public class Main {
    public static void main(String[] args) {
        System.out.println("The ThreadPool LLD");

        ThreadPool threadPool = ThreadPool.getThreadPoolInstance(3);

        for(int i = 0; i <= 10; i++){
            Task task = new Task("Task "+i);
            threadPool.submitTask(task);
        }

        threadPool.shutDown();
    }
}
