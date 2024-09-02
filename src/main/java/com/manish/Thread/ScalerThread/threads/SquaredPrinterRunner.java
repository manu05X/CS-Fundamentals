package com.manish.Thread.ScalerThread.threads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/*
5> newCachedThreadPool executor does not have upperlimit so it keep on creating threads benefit of using it is reuses them
 we uses it when we dont know how many thread we need

Create threads or reuse them
when a task comes in
if a thread is available, it will use it
if a thread is not available, it will create one

*/
public class SquaredPrinterRunner {

    public static void main(String[] args) {
        //Create a list of values
        //List.of(1,2,3,4,5) initializes array/list very easily
        List<Integer> values = List.of(1,2,3,4,5);

        //Here no upperlimit of thread exist, it keeps on creating thread
        Executor executor = Executors.newCachedThreadPool();

        System.out.println(Thread.currentThread().getName());
        //Iterate over the list and create a thread
        for(Integer value:values){
            //task i.e SquarePrinter obj is created and is instantiated with the value from the list.
            SquarePrinter obj = new SquarePrinter(value);

            executor.execute(obj);
            //This line submits the obj (a SquarePrinter object) for execution in the single-threaded executor service (executor).
        }
    }
}


/*
//4> FixedThreadPool executer have maximum upper limit of how many thread to be used
public class SquaredPrinterRunner {

    public static void main(String[] args) {
        //Create a list of values
        //List.of(1,2,3,4,5) initializes arry/list very easly
        List<Integer> values = List.of(1,2,3,4,5);

        //Here maximum of 3 thread can be used i.e max of 3 thread can be used
        Executor executor = Executors.newFixedThreadPool(3);

        System.out.println(Thread.currentThread().getName());
        //Iterate over the list and create a thread
        for(Integer value:values){
            //task i.e SquarePrinter obj is created and is instantiated with the value from the list.
            SquarePrinter obj = new SquarePrinter(value);

            executor.execute(obj);
            //This line submits the obj (a SquarePrinter object) for execution in the single-threaded executor service (executor).
        }
    }
}

/*

//3> executer
public class SquaredPrinterRunner {

    public static void main(String[] args) {
        //Create a list of values
        //List.of(1,2,3,4,5) initializes arry/list very easly
        List<Integer> values = List.of(1,2,3,4,5);
        Executor executor = Executors.newSingleThreadExecutor();
        //Here, you create an Executor object named executor. The Executors.newSingleThreadExecutor() method creates a new single-threaded executor service. This executor service can be used to execute tasks in a separate thread.

        System.out.println(Thread.currentThread().getName());
        //Iterate over the list and create a thread
        for(Integer value:values){
            //task i.e SquarePrinter obj is created and is instantiated with the value from the list.
            SquarePrinter obj = new SquarePrinter(value);

            executor.execute(obj);
            //This line submits the obj (a SquarePrinter object) for execution in the single-threaded executor service (executor).
        }
    }
}
*/
//Redis - uses hashMap - key->value - SingleThreadExecutor
// redis solve syncronization has to handle multiple thread so if multiple thread writes it causes inconsistence so internally it uses single-threaded executor to make the final change in the value of a key
// SingleThreadExecutor is useful when we want only one thread to modify something or do certain task

/*
//1> subthreading
public class SquaredPrinterRunner {

    public static void main(String[] args) {
        //Create a list of values
        //List.of(1,2,3,4,5) initializes arry/list very easly
        List<Integer> values = List.of(1,2,3,4,5);

        //Iterate over the list and create a thread
        for(Integer value:values){
            //obj of SquarePrinter class is created but refrance from Thread class
            Thread thread = new SquarePrinter(value);
            //Now Execute the thread
            thread.start();
        }
    }
}
*/
//https://github.com/kanmaytacker/fundamentals/blob/2023/august/advanced/os/code/os/src/main/java/com/scaler/threads/Squared.java

/*
//2> runable interface
package main.ScalerThread.threads;

import java.util.List;

public class SquaredPrinterRunner {

    public static void main(String[] args) {
        //Create a list of values
        //List.of(1,2,3,4,5) initializes arry/list very easly
        List<Integer> values = List.of(1,2,3,4,5);

        //Iterate over the list and create a thread
        for(Integer value:values){
            //task i.e SquarePrinter obj is created
            SquarePrinter obj = new SquarePrinter(value);

            //obj of SquarePrinter is passed in thread class obj
            Thread thread = new Thread(obj);

            //Now Execute the thread
            thread.start();
        }
    }
}

*/


//________________________________________________
/*
import java.util.concurrent.Executor;
class ThreadExecutorExample {

  public static void main( String args[] ) {
     DumbExecutor myExecutor = new DumbExecutor();
     MyTask myTask = new MyTask();
     myExecutor.execute(myTask);
  }

  static class DumbExecutor implements Executor {
    // Takes in a runnable interface object
    public void execute(Runnable runnable) {
      Thread newThread = new Thread(runnable);
      newThread.start();
    }
  }

  static class MyTask implements Runnable {
    public void run() {
      System.out.println("Mytask is running now ...");
    }
  }

}

The Executor requires implementing classes to define a method execute(Runnable runnable) which takes in an object of interface Runnable.
Thread Pools
Thread pools in Java are implementations of the Executor interface or any of its sub-interfaces. Thread pools allow us to decouple task submission and execution.

Types of Thread Pools

Java has preconfigured thread pool implementations that can be instantiated using the factory methods of the Executors class. The important ones are listed below:

newFixedThreadPool: This type of pool has a fixed number of threads and any number of tasks can be submitted for execution. Once a thead finishes a task, it can reused to execute another task from the queue.

newSingleThreadExecutor: This executor uses a single worker thread to take tasks off of queue and execute them. If the thread dies unexpectedly, then the executor will replace it with a new one.

newCachedThreadPool: This pool will create new threads as required and use older ones when they become available. However, it'll terminate threads that remain idle for a certain configurable period of time to conserve memory. This pool can be a good choice for short-lived asynchronous tasks.

newScheduledThreadPool: This pool can be used to execute tasks periodically or after a delay.

There is also another kind of pool which we'll only mention in passing as it's not widely used: ForkJoinPool. A prefconfigured version of it can be instantiated using the factory method Executors.newWorkStealingPool(). These pools are used for tasks which fork into smaller subtasks and then join results once the subtasks are finished to give an uber result. It's essentially the divide and conquer paradigm applied to tasks.

Using thread pools we are able to control the order in which a task is executed, the thread in which a task is executed, the maximum number of tasks that can be executed concurrently, maximum number of tasks that can be queued for execution, the selection criteria for rejecting tasks when the system is overloaded and finally actions to take before or after execution of tasks.
__________________
Executor Lifecycle
An executor has the following stages in its lify-cycle:

Running

Shutting Down

Terminated

As mentioned earlier, JVM can't exit unless all non-daemon thread have terminated. Executors can be made to shutdown either abruptly or gracefully. When doing the former, the executor attempts to cancel all tasks in progress and doesn't work on any enqueued ones, whereas when doing the latter, the executor gives a chance for tasks already in execution to complete but also completes the enqueued tasks. If shutdown is initiated then the executor will refuse to accept new tasks and if any are submitted, they can be handled by providing a RejectedExecutionHandler.


*/