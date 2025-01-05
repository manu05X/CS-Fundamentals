package com.manish.Thread.CodeQuestion.AVolatile;

//1. Without Volatile Keyword
/*
public class Counter { // Define a Counter class
    private int count = 0; // A private field to keep track of the count

    // Method to increment the count
    public void increment() {
        count++; // Increment the count by 1 (not thread-safe)
    }

    // Method to retrieve the current value of count
    public int getCount() {
        return count; // Return the current value of count
    }

    public static void main(String[] args) { // Entry point of the program
        Counter counter = new Counter(); // Create an instance of the Counter class

        Thread[] threads = new Thread[1000]; // Array to hold 1000 threads
        for (int i = 0; i < 1000; i++) { // Loop to create 1000 threads
            threads[i] = new Thread(counter::increment); // Each thread calls the increment method
            threads[i].start(); // Start the thread
        }

        for (int i = 0; i < 1000; i++) { // Loop to ensure all threads complete execution
            try {
                threads[i].join(); // Main thread waits for the current thread to finish
            } catch (InterruptedException e) { // Handle interruption during join
                e.printStackTrace(); // Print stack trace if an exception occurs
            }
        }

        // Print the final value of count after all threads have finished execution
        System.out.println("Final Count: " + counter.getCount());
    }
}


*/


//2. Using Synchronized Mehod or Block
/*
public class Counter {
    private int count = 0;

    //Using synchronized keyword method
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // 1000 thread that increase the counter
        Thread[] threads = new Thread[1000];
        for(int i = 0; i < 1000; i++){
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }

        //Wait for all threads to finish
        for(int i =0; i < 1000; i++){
            try{
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Final Count: "+ counter.getCount());
    }
}
*/


//3. Using AtomicInteger
/*
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    // Using AtomicInteger count
    private AtomicInteger count = new AtomicInteger(0);


    public void increment(){
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // 1000 thread that increase the counter
        Thread[] threads = new Thread[1000];
        for(int i = 0; i < 1000; i++){
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }

        //Wait for all threads to finish
        for(int i =0; i < 1000; i++){
            try{
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Final Count: "+ counter.getCount());
    }
}

*/

//4. Using Volatile

public class Counter { // Define a Counter class
    private int count = 0; // A private field to keep track of the count

    // Method to increment the count
    public void increment() {
        count++; // Increment the count by 1 (not thread-safe)
    }

    // Method to retrieve the current value of count
    public int getCount() {
        return count; // Return the current value of count
    }

    public static void main(String[] args) { // Entry point of the program
        Counter counter = new Counter(); // Create an instance of the Counter class

        Thread[] threads = new Thread[1000]; // Array to hold 1000 threads
        for (int i = 0; i < 1000; i++) { // Loop to create 1000 threads
            threads[i] = new Thread(counter::increment); // Each thread calls the increment method
            threads[i].start(); // Start the thread
        }

        for (int i = 0; i < 1000; i++) { // Loop to ensure all threads complete execution
            try {
                threads[i].join(); // Main thread waits for the current thread to finish
            } catch (InterruptedException e) { // Handle interruption during join
                e.printStackTrace(); // Print stack trace if an exception occurs
            }
        }

        // Print the final value of count after all threads have finished execution
        System.out.println("Final Count: " + counter.getCount());
    }
}
