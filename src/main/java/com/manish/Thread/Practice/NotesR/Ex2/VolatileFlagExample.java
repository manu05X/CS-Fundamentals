package com.manish.Thread.Practice.NotesR.Ex2;

public class VolatileFlagExample {
    private volatile boolean running = true;
    
    public void stop() {
        running = false;
    }
    
    public void doWork() {
        System.out.println("Worker thread started");
        while (running) {
            // Perform some work
        }
        System.out.println("Worker thread stopped");
    }
    
    public static void main(String[] args) {
        VolatileFlagExample example = new VolatileFlagExample();
        
        // Thread to perform work
        /*
        Thread workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                example.doWork();
            }
        });
         */
        // Thread workerThread = new Thread(() -> example.doWork()); older way
        Thread workerThread = new Thread(example::doWork);
        workerThread.start();
        
        try {
            // Sleep for a while and then stop the worker
            Thread.sleep(2000); // The main thread sleeps for 2 seconds (2000 milliseconds).
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        example.stop(); // Stop the worker thread
        
        try {
            // Wait for the worker thread to finish
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main thread finished");
    }
}


/*
Understanding workerThread.join() After example.stop()
When you call example.stop(), it sets running = false, which causes the worker thread (workerThread) to exit its while(running) loop and terminate naturally.

But why do we need workerThread.join() after stopping it?

What Happens Step-by-Step?
Main thread starts workerThread

workerThread begins executing doWork().

It keeps running while running == true.

Main thread sleeps for 2 seconds (Thread.sleep(2000))

The worker thread continues running during this time.

Main thread calls example.stop()

This sets running = false (due to volatile, the change is immediately visible to the worker thread).

The worker thread sees running == false and exits the loop, printing "Worker thread stopped".

Main thread calls workerThread.join()

This waits for the worker thread to fully terminate before the main thread continues.

Since the worker thread already stopped naturally, join() returns almost immediately.

Why Call join() If the Thread Already Stopped?
Guarantees clean termination (ensures the worker thread has fully finished before the program proceeds).

Prevents race conditions (if the main thread tried to access shared resources immediately after stop(), join() ensures the worker is done).

Good practice even if the thread exits quickly.

What If We Didn’t Call join()?
The main thread might exit before the worker thread (though unlikely in this case since stop() is fast).

If the program ends abruptly (e.g., System.exit()), the worker thread might not get a chance to clean up.

Example Without join() (Bad Practice)

example.stop(); // Worker thread will stop... eventually
// workerThread.join(); // Not waiting!
System.out.println("Main thread finished"); // Could print before worker stops
Possible Output (Race Condition):

Copy
Worker thread started
Main thread finished  // Oops! Main thread finished first?
Worker thread stopped
(Unlikely here, but possible in more complex programs.)

Key Takeaways
stop() → Signals the worker thread to exit (due to volatile flag).

join() → Ensures the worker thread fully terminates before the main thread continues.

Best practice: Always join() background threads unless designed to run indefinitely (like daemon threads).
 */




/*
In the line Thread workerThread = new Thread(example::doWork);, the expression example::doWork is a method reference in Java. It's a shorthand way to pass a method as a lambda expression to the Thread constructor.

Explanation:
1> Thread Constructor Expects a Runnable
        The Thread class constructor accepts a Runnable (a functional interface with a single run() method). Instead of passing an anonymous class or a lambda, we can pass a method reference.

2> example::doWork Refers to the doWork() Method

    -> example is an instance of VolatileFlagExample.
    -> :: is the method reference operator.
    -> doWork is the method to be executed when the thread starts.

This is equivalent to:
    Thread workerThread = new Thread(() -> example.doWork());

or the older anonymous class style:
    Thread workerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            example.doWork();
        }
    });
Why Use Method References?
More concise than lambda or anonymous class syntax.

Better readability when the method name clearly describes the action.

Reuses existing methods rather than rewriting them in a lambda.

Types of Method References:

Type	             Syntax	            Example
Static method	     Class::method	    Math::sqrt
Instance method	     instance::method	example::doWork
Arbitrary object	 Class::method	    String::length (on any String)
Constructor	         Class::new	        ArrayList::new

In your case, example::doWork is an instance method reference, meaning the doWork() method will be called on the example object when the thread runs.
 */
