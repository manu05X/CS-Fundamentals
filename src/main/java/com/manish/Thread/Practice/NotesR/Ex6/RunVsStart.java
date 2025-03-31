package com.manish.Thread.Practice.NotesR.Ex6;

public class RunVsStart {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Executing in thread: " + Thread.currentThread().getName());
        });
        
        // Calling run() directly
        System.out.println("Calling run() directly:");
        thread.run();  // Runs in main thread
        
        // Calling start() properly
        System.out.println("\nCalling start():");
        thread.start(); // Creates new thread
    }
}