package com.manish.LLD.ThreadPool;

// Task class implementing Runnable (Factory Method Pattern)
public class Task implements Runnable{
    private final String taskName;

    public Task(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Executing Task: "+ taskName);

        try{
            Thread.sleep(1000); // Simulate task execution
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Task Completed: "+ taskName);
    }
}
