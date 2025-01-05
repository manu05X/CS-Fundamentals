package com.manish.Thread.CodeQuestion.BCreateThread.CallableExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static ExecutorService executerService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        CallableMessage task = new CallableMessage();

        Future<String> futureMessage = executerService.submit(task);

        //System.out.println(futureMessage);
        try {
            // Fetch the result of the task
            String result = futureMessage.get(); // Blocks until the task is complete
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Exception occurred while fetching the result: " + e.getMessage());
        } finally {
            executerService.shutdown();
        }
    }
}
