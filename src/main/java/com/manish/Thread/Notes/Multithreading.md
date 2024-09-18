# Java Multithreading and Concurrency Interview Revision Guide

#### Q Java Multithreading is a critical aspect of Java programming, especially in today's world where parallel and concurrent processing are becoming increasingly important. Concurrency in Java stands as one of the most intricate and advanced subjects often discussed in technical interviews.

Imagine Java multithreading as a team of skilled chefs working together in a large kitchen to prepare a complex meal. Each chef represents a thread in Java, capable of independently carrying out tasks.

- Just like the chefs can divide tasks efficiently to speed up meal preparation, Java threads can execute multiple tasks simultaneously, making the program more efficient and responsive.
- If one chef encounters a bottleneck, such as waiting for an ingredient to be prepared, other chefs can continue working on different tasks, ensuring maximum utilization of resources and reducing idle time.
- By coordinating and communicating effectively, the chefs can synchronize their efforts to ensure that all components of the meal come together harmoniously at the right time. Similarly, Java provides mechanisms like synchronization and locks to coordinate thread activities and avoid conflicts.
- When the meal is ready, the chefs present a beautifully orchestrated dish. Similarly, in Java multithreading, when threads complete their tasks and synchronize their results, the program can deliver a seamless and high-performance outcome.

#### Q What Is the Difference Between a Process and a Thread?
In Java programming, a process and a thread are both units of execution, but they operate at different levels of abstraction and have distinct characteristics.

A process can be thought of as an independent entity that runs in its own memory space and has its own resources, including memory, file handles, and system resources. Processes are heavyweight entities, and each process operates independently of other processes. Examples of processes include running multiple instances of a web browser or a text editor on your computer. Each instance operates as a separate process, with its own memory space and resources.

On the other hand, a thread is a lightweight unit of execution that exists within a process. Threads share the same memory space and resources as the process to which they belong. Multiple threads can exist within a single process and share resources such as memory and file handles. Threads are used to achieve concurrency within a program, allowing multiple tasks to be performed simultaneously. For example, in a web server application, multiple threads can handle incoming client requests concurrently, improving the server's responsiveness and efficiency.

> Real-World Use Case Examples:
> - **Web Browser**: When you open multiple tabs in a web browser, each tab typically runs as a separate process. This isolation ensures that if one tab crashes or experiences issues, it does not affect the other tabs or the browser itself. Within each tab, multiple threads handle tasks such as rendering web pages, processing user input, and downloading resources concurrently.
> - **Word Processing Application**: In a word processing application like Microsoft Word, the application itself runs as a process. Within the application, various threads handle tasks such as user interface interactions, spell-checking, auto-saving, and printing. These threads operate concurrently, providing a smooth and responsive user experience.


#### How can we create a Thread in Java?
 - You can create a thread instance by either extending the Thread class or implementing the Runnable interface. Once you have created a thread instance, you can start it by calling the start() method. Please find below the code snippet for both the approaches:
```java
// Define a class that extends Thread
class MyThread extends Thread {
    public void run() {
        // Code to be executed by the thread
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of MyThread
        MyThread myThread = new MyThread();
        // Start the thread
        myThread.start();
    }
}

```

```java
// Define a class that implements the Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed by the thread
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of MyRunnable
        MyRunnable myRunnable = new MyRunnable();
        // Create a Thread instance and pass MyRunnable as a parameter
        Thread thread = new Thread(myRunnable);
        // Start the thread
        thread.start();
    }
}
```

#### Describe the Different States of a Thread?
During its lifecycle, a thread in Java can exist in several states, each representing a different stage of its execution. Please find below the different states of a thread:

**New:**
When a thread is created but not yet started, it is in the "New" state.
In this state, the thread has been instantiated, but the start() method has not been called.

**Runnable:**
After calling the start() method, the thread moves to the "Runnable" state.
In this state, the thread is eligible to run, but the scheduler has not yet selected it to be the running thread.

**Running:**
When the thread scheduler selects a thread from the "Runnable" state for execution, it enters the "Running" state.
In this state, the thread's code is actively being executed by the CPU.

**Blocked (or Waiting):**
A thread enters the "Blocked" state when it is temporarily inactive, typically because it is waiting for a resource or condition to become available.
For example, a thread may be blocked while waiting for I/O operations to complete or waiting to acquire a lock.

**Timed Waiting:**
Threads can also enter a "Timed Waiting" state, where they pause execution for a specified period.
This state occurs when a thread calls methods such as sleep() or join() with a specified timeout.

**Terminated:**
The final state of a thread is "Terminated."
This state indicates that the thread has completed its execution and will not run further.
Threads can enter this state either by successfully completing their task or by being explicitly stopped.

**Real-World Use Case:**

Imagine you're building a chat application. Each user's interaction with the chat interface is handled by a separate thread. Here's how the different thread states might come into play:

**New:** When a new user opens the chat application, a thread is created to handle their interactions.

**Runnable:** Once the user logs in, their thread transitions to the "Runnable" state, awaiting execution by the thread scheduler.

**Running:** When the scheduler selects the user's thread for execution, it enters the "Running" state, actively processing messages and user inputs.

**Blocked:** If the user sends a message and it needs to be sent over the network, the thread might enter the "Blocked" state while waiting for the network I/O operation to complete.

**Terminated:** Once the user logs out or closes the application, their thread enters the "Terminated" state, indicating the end of its lifecycle.

![img.png](img.png)

#### What Is a Daemon Thread and how to create a Daemon Thread? What are the real use cases of Daemon thread?
A daemon thread in Java is a special type of thread that runs in the background, providing services to other threads or performing tasks that are not critical to the application's lifecycle. Unlike user threads, daemon threads do not prevent the JVM from exiting when all user threads have finished executing. They are automatically terminated when all non-daemon threads have exited or when the JVM shuts down.

##### Real-World Use Cases:

**Garbage Collection:** Daemon threads are commonly used by the JVM for tasks such as garbage collection. The JVM creates a daemon thread to perform garbage collection in the background, ensuring that unused memory is reclaimed while the application continues to execute.

**Monitoring Services:** Daemon threads can be used to monitor system resources or perform periodic maintenance tasks in the background. For example, a daemon thread might monitor disk usage, network traffic, or system performance metrics without interfering with the main application's execution.

**Background Tasks:** In server-side applications, daemon threads can be used to handle background tasks such as logging, sending periodic heartbeats to a monitoring system, or cleaning up temporary files. These tasks are essential for the application's operation but do not require dedicated user threads.

By using daemon threads, you can offload non-critical tasks to background threads, improving the overall responsiveness and efficiency of your Java applications

To create a daemon thread in Java, you simply need to set the daemon flag to true before starting the thread.

```java
public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000); // Simulate some task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemonThread.setDaemon(true); // Set the thread as daemon
        daemonThread.start(); // Start the daemon thread
    }
}

```

#### What Is the Difference Between the Runnable and Callable Interfaces? https://www.geeksforgeeks.org/difference-between-callable-and-runnable-in-java/
The Runnable and Callable interfaces in Java both represent tasks that can be executed by threads, but they differ in several key aspects:

##### Return Value:
- The Runnable interface does not return a result when its task completes. Its run() method has a void return type.
- The Callable interface, on the other hand, can return a result when its task completes. It defines a call() method that returns a result of a specified type.

##### Exception Handling:
- In the Runnable interface, any checked exceptions thrown by the run() method must be caught and handled within the method itself.
- The Callable interface allows the call() method to throw checked exceptions. These exceptions can be caught and handled by the calling code.

##### Usage with Executors:
- The Runnable interface is primarily used with the Executor framework for executing tasks asynchronously in a thread pool.
- The Callable interface is used with the ExecutorService framework, which provides additional features such as the ability to submit tasks that return values and handle exceptions.

```java
// Java Program to illustrate Callable interface 

// Importing classes from java.util package 
import java.util.Random; 
import java.util.concurrent.Callable; 
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Class
// Implementing the Callable interface
class CallableMessage implements Callable<String>{
public String call() throws Exception{
	return "Hello World!";
} 
}

public class CallableExample{
static ExecutorService executor = Executors.newFixedThreadPool(2);
	public static void main(String[] args) throws Exception{
		CallableMessage task = new CallableMessage();
		Future<String> message = executor.submit(task);
		System.out.println(message.get().toString());
	}
}
//___________________________________________________________________________________________
package java.util.concurrent;

/**
 * A task that returns a result and may throw an exception.
 * Implementors define a single method with no arguments called
 * {@code call}.
 *
 * <p>The {@code Callable} interface is similar to {@link
 * java.lang.Runnable}, in that both are designed for classes whose
 * instances are potentially executed by another thread.  A
 * {@code Runnable}, however, does not return a result and cannot
 * throw a checked exception.
 *
 * <p>The {@link Executors} class contains utility methods to
 * convert from other common forms to {@code Callable} classes.
 *
 * @see Executor
 * @since 1.5
 * @author Doug Lea
 * @param <V> the result type of method {@code call}
 */
@FunctionalInterface
public interface Callable<V> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    V call() throws Exception;
}
```

```java
// Java Program to implement Runnable interface
/*
public interface Runnable
{
    public abstract void run();
}
*/
 */

// Importing FileNotFound class from
// input output classes bundle
import java.io.FileNotFoundException;
import java.util.concurrent.*;

// Class
// Implementing the Runnable interface 
class RunnableImpl implements Runnable {

public void run()
{
	System.out.println("Hello World from a different thread than Main");
}
}
public class RunnableExample{
	static ExecutorService executor = Executors.newFixedThreadPool(2);
public static void main(String[] args){
		// Creating and running runnable task using Thread class
		RunnableImpl task = new RunnableImpl();
		Thread thread = new Thread(task);
		thread.start();
		// Creating and running runnable task using Executor Service.
		executor.submit(task);
	}
}

```

#### What Is Java Memory Model (JMM) and it' s purpose?
- The Java Memory Model (JMM) defines how Java programs interact with memory, including how threads interact through memory when executing concurrently. Its purpose is to ensure that concurrent Java programs behave predictably and consistently across different platforms and JVM implementations.

- The Java memory model specifies how the Java virtual machine works with the computer's memory (RAM).

- Each **Java thread operates with its own thread stack**, which maintains the call stack – a record of invoked methods leading to the current execution point. Local variables for each method reside in the thread stack and are exclusive to that thread.

- In contrast, **the heap stores all objects created within the Java application**, irrespective of the creating thread. This includes object versions of primitive types. Whether an object is assigned to a local or a member variable, it's stored in the heap.

![img_1.png](img_1.png)

#### What is Data Race Condition and Visibility problem?
**Data Race Condition:**
- A data race condition occurs when two or more threads access shared data concurrently, and at least one of the threads modifies the data. This can lead to unpredictable behavior and incorrect results due to the non-deterministic interleaving of thread operations. Data races can occur when threads access shared variables without proper synchronization, leading to inconsistent or corrupted data.

**Visibility Problem:**
- The visibility problem refers to the issue where changes made by one thread to shared variables may not be immediately visible to other threads. In Java, each thread has its own cache of variables, and changes made by one thread may not be immediately propagated to other threads' caches. This can result in one thread not seeing the most recent value of a shared variable, leading to incorrect behavior.

**Real-World Use Case:**
- Consider a scenario where multiple threads are updating a shared counter variable. Without proper synchronization, such as using locks or volatile variables, data races can occur. For instance, one thread may read the counter's value while another thread is in the process of updating it, leading to inconsistent or incorrect results. Additionally, if one thread updates the counter, other threads may not immediately see the updated value due to visibility issues.

```java
public class Counter {
    private int count;

    public void increment() {
        count++; // Not thread-safe
    }

    public int getCount() {
        return count; // Not thread-safe
    }
}

```

#### What is difference between Volatile, Atomic and Synchronized?
**Volatile:** The volatile keyword in Java is used to indicate that a variable's value may be modified by multiple threads, and changes to the variable should be immediately visible to other threads. However, it does not provide atomicity or mutual exclusion. Instead, it ensures that reads and writes to the variable are not reordered by the compiler or processor, thereby addressing the visibility problem.

**Atomic:** The java.util.concurrent.atomic package provides classes like AtomicInteger, AtomicLong, and AtomicReference, which offer atomic operations on variables without the need for explicit synchronization. These classes use compare-and-set (CAS) operations to ensure that updates to the variables are performed atomically and without data races. They are suitable for scenarios where operations like incrementing or updating variables need to be thread-safe.

**Synchronized:** The synchronized keyword in Java is used to create a mutually exclusive block of code, known as a synchronized block, which can only be executed by one thread at a time. It ensures that only one thread can execute the synchronized block, while other threads are blocked until the lock is released. Synchronization provides both atomicity and mutual exclusion, ensuring thread safety by preventing data races and ensuring consistent access to shared resources.

Real-World Use Cases:

**Volatile:** Use volatile when you have a variable that is shared among multiple threads, and you want to ensure that changes to the variable's value are immediately visible to other threads without the need for locking. For example, a flag indicating whether a thread should continue running.

**Atomic:** Use atomic variables when you need to perform atomic operations like incrementing, updating, or comparing variables in a thread-safe manner. For example, maintaining a global counter or implementing thread-safe caching mechanisms.

**Synchronized:** Use synchronized blocks when you need to ensure that only one thread can access a block of code or modify shared resources at a time. For example, updating shared data structures or performing critical operations that require exclusive access.

```java
// Volatile
public class VolatileExample {
    private volatile boolean flag;

    public void setFlag(boolean value) {
        flag = value;
    }

    public boolean getFlag() {
        return flag;
    }
}

// Atomic
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}

// Synchronized
public class SynchronizedExample {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}


```

#### Explain about Deadlock, Livelock, and Starvation conditions in Java Multithreading?
**Deadlock:**
Deadlock occurs when two or more threads are blocked forever, waiting for each other to release the resources they need. Each thread holds a resource that another thread needs, creating a circular dependency.

- **Example:** Thread A holds Resource 1 and waits for Resource 2, while Thread B holds Resource 2 and waits for Resource 1. Both threads are blocked indefinitely.
- **Prevention:** Avoid circular dependencies by ensuring a consistent ordering of resource acquisition, use timeouts for acquiring locks, and consider using higher-level synchronization constructs.

**Livelock:**
Livelock occurs when two or more threads are actively trying to resolve a deadlock but end up constantly changing their states without making progress. Each thread sacrifices its own progress to avoid blocking.
- **Example:** Two people meet in a narrow corridor, and each tries to step aside to let the other pass. However, they continuously step in the same direction, preventing either from passing.
- **Prevention:** Introduce randomness or delays in the retry mechanism, change the algorithm to break the symmetry, or use higher-level coordination mechanisms like message passing.

**Starvation:**
Starvation occurs when a thread is unable to gain regular access to shared resources and is continuously denied service or delayed indefinitely.
- **Example:** A low-priority thread may be constantly preempted by higher-priority threads, causing it to wait indefinitely for CPU time, disk access, or other resources.
- **Prevention:** Use fair scheduling policies to ensure that all threads have a fair chance to access shared resources, prioritize critical tasks, and periodically reassess thread priorities.

**Real-World Use Cases:**

**Deadlock:** Consider a scenario where two threads need to acquire locks on two resources in a different order. Without proper synchronization, this can lead to a deadlock scenario.

**Livelock:** A live-lock occurs when two threads continuously react in response to the actions by the other thread without making any real progress.In a distributed system, multiple nodes may attempt to negotiate resource allocation in a decentralized manner, leading to livelock if they repeatedly adjust their requests without making progress.

**Starvation:** In a multi-threaded server application, low-priority client requests may be continuously delayed or preempted by high-priority requests, leading to starvation for low-priority clients.


#### Mutex
- Mutex as the name hints implies *mutual exclusion*. A mutex is used to guard shared data such as a linked-list, an array or any primitive type. A mutex allows only a single thread to access a resource or critical section.
- Once a thread acquires a mutex, all other threads attempting to acquire the same mutex are blocked until the first thread releases the mutex. Once released, most implementations arbitrarily chose one of the waiting threads to acquire the mutex and make progress.

#### Semaphore
- Semaphore, on the other hand, is used for limiting access to a collection of resources. Think of semaphore as having a limited number of permits to give out. If a semaphore has given out all the permits it has, then any new thread that comes along requesting for a permit will be blocked, till an earlier thread with a permit returns it to the semaphore.
- A semaphore with a single permit is called a binary semaphore and is often thought of as an equivalent of a mutex, which isn’t completely correct as we’ll shortly explain. 
- Semaphores can also be used for signaling among threads. This is an important distinction as it allows threads to cooperatively work towards completing a task. A mutex, on the other hand, is strictly limited to serializing access to shared state among competing threads.

#### When a Semaphore Masquerades as a Mutex?
A semaphore can potentially act as a mutex if the permits it can give out is set to 1. However, the most important difference between the two is that in case of a mutex **the same thread must call acquire and subsequent release on the mutex** whereas in case of a binary sempahore, **different threads can call acquire and release on the semaphore**. The pthreads library documentation states this in the *pthread_mutex_unlock()* method’s description.
>If a thread attempts to unlock a mutex that it has not locked or a mutex which is unlocked, undefined behavior results.

This leads us to the concept of ownership. A mutex is owned by the thread acquiring it till the point the owning-thread releases it, whereas for a semaphore there’s no notion of ownership.

#### MUTEX VS SEMAPHORE
- Mutex implies mutual exclusion and is used to serialize access to critical sections whereas semaphore can potentially be used as a mutex but it can also be used for cooperation and signaling amongst threads. Semaphore also solves the issue of missed signals.

- Mutex is owned by a thread, whereas a semaphore has no concept of ownership.

- Mutex if locked, must necessarily be unlocked by the same thread. A semaphore can be acted upon by different threads. This is true even if the semaphore has a permit of one.

- Think of semaphore analogous to a car rental service such as Hertz. Each outlet has a certain number of cars, it can rent out to customers. It can rent several cars to several customers at the same time but if all the cars are rented out then any new customers need to be put on a waitlist till one of the rented cars is returned. In contrast, think of a mutex like a lone runway on a remote airport. Only a single jet can land or take-off from the runway at a given point in time. No other jet can use the runway simultaneously with the first aircraft.

#### Task
- A task is a logical unit of work. Usually, a task should be independent of other tasks so that it can be completed by a single thread. A task can be represented by an object of a class implementing the Runnable interface. We can consider HTTP requests being fielded by a web-server as tasks that need to be processed. A database server handling client queries can similarly be thought of as independent tasks.

#### Executor Framework
In Java, the primary abstraction for executing logical tasks units is the Executor framework and not the Thread class. The classes in the Executor framework separate out:

- Task Submission
- Task Execution

The framework allows us to specify different policies for task execution. Java offers three interfaces, which classes can implement to manage thread lifecycle. These are:

- Executor Interface
- ExecutorService
- ScheduledExecutorService

The Executor interface forms the basis for the asynchronous task execution framework in Java.

You don't need to create your own executor class as Java's *java.util.concurrent* package offers several types of executors that are suitable for different scenarios. However, as an example, we create a dumb executor which implements the Executor Interface.

```java
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
//The Executor requires implementing classes to define a method execute(Runnable runnable) which takes in an object of interface Runnable.
```
#### Thread Pools
Thread pools in Java are implementations of the Executor interface or any of its sub-interfaces. Thread pools allow us to decouple task submission and execution. We have the option of exposing an executor's configuration while deploying an application or switching one executor for another seamlessly.

>A thread pool consists of homogenous worker threads that are assigned to execute tasks. Once a worker thread finishes a task, it is returned to the pool. Usually, thread pools are bound to a queue from which tasks are dequeued for execution by worker threads.

A thread pool can be tuned for the size of the threads it holds. A thread pool may also replace a thread if it dies of an unexpected exception. Using a thread pool immediately alleviates from the ails of manual creation of threads.

- There's no latency when a request is received and processed by a thread because no time is lost in creating a thread.

- The system will not go out of memory because threads are not created without any limits

- Fine tuning the thread pool will allow us to control the throughput of the system. We can have enough threads to keep all processors busy but not so many as to overwhelm the system.

- The application will degrade gracefully if the system is under load.

Below is the updated version of the stock order method using a thread pool.

```java
 void receiveAndExecuteClientOrdersBest() {

        int expectedConcurrentOrders = 100;
        Executor executor = Executors.newFixedThreadPool(expectedConcurrentOrders);

        while (true) {
            final Order order = waitForNextOrder();

            executor.execute(new Runnable() {

                public void run() {
                    order.execute();
                }
            });
        }
    }
    //In the above code we have used the factory method exposed by the Executors class to get an instance of a thread pool
```
#### Types of Thread Pools

Java has preconfigured thread pool implementations that can be instantiated using the factory methods of the Executors class. The important ones are listed below:

- `newFixedThreadPool:` This type of pool has a fixed number of threads and any number of tasks can be submitted for execution. Once a thead finishes a task, it can reused to execute another task from the queue.

- `newSingleThreadExecutor:` This executor uses a single worker thread to take tasks off of queue and execute them. If the thread dies unexpectedly, then the executor will replace it with a new one.

- `newCachedThreadPool:` This pool will create new threads as required and use older ones when they become available. However, it'll terminate threads that remain idle for a certain configurable period of time to conserve memory. This pool can be a good choice for short-lived asynchronous tasks.

- `newScheduledThreadPool:` This pool can be used to execute tasks periodically or after a delay.

There is also another kind of pool which we'll only mention in passing as it's not widely used: `ForkJoinPool`. A prefconfigured version of it can be instantiated using the factory method `Executors.newWorkStealingPool()`. These pools are used for tasks which fork into smaller subtasks and then join results once the subtasks are finished to give an uber result. It's essentially the divide and conquer paradigm applied to tasks.

Using thread pools we are able to control the order in which a task is executed, the thread in which a task is executed, the maximum number of tasks that can be executed concurrently, maximum number of tasks that can be queued for execution, the selection criteria for rejecting tasks when the system is overloaded and finally actions to take before or after execution of tasks.

#### Executor Lifecycle
An executor has the following stages in its lify-cycle:

- Running
- Shutting Down
- Terminated

As mentioned earlier, JVM can't exit unless all non-daemon thread have terminated. Executors can be made to shutdown either abruptly or gracefully. When doing the former, the executor attempts to cancel all tasks in progress and doesn't work on any enqueued ones, whereas when doing the latter, the executor gives a chance for tasks already in execution to complete but also completes the enqueued tasks. If shutdown is initiated then the executor will refuse to accept new tasks and if any are submitted, they can be handled by providing a `RejectedExecutionHandler`.


#### What is Java Executor Service and type of threadpools which can be created with Java Executor service?
The Java Executor Service is a higher-level concurrency utility that provides a simplified interface for managing threads and executing tasks asynchronously. It abstracts away the complexity of thread management, making our lives as developers much easier

**Types of Thread Pools:**

**FixedThreadPool:**
Description: A FixedThreadPool maintains a fixed number of threads in the pool. If a task is submitted when all threads are busy, it is queued until a thread becomes available.
Use Case: Suitable for scenarios where you have a predictable number of tasks and want to limit the maximum number of concurrent threads.

**CachedThreadPool:**
Description: A CachedThreadPool dynamically adjusts the number of threads based on the workload. Threads are created as needed and reused if available. Unused threads are terminated after a specified idle timeout.
Use Case: Ideal for scenarios with a large number of short-lived tasks or when the workload varies over time.

**SingleThreadPool:**
Description: A SingleThreadPool maintains a single thread in the pool, ensuring that tasks are executed sequentially in the order they were submitted. If the thread terminates due to an exception, a new one is created to replace it.
Use Case: Useful for scenarios where tasks must be executed sequentially or when you want to decouple task execution from the main application thread.

**ScheduledThreadPool:**
Description: A ScheduledThreadPool is used for executing tasks at a specific time or with a fixed delay between executions. It maintains a pool of threads and supports scheduling tasks with methods like schedule(), scheduleAtFixedRate(), and scheduleWithFixedDelay().
Use Case: Ideal for scenarios requiring periodic execution of tasks, such as scheduling background tasks or running recurring jobs.

#### Real-World Use Case Example:
Suppose you're developing a web server application where multiple client requests need to be processed concurrently. You can use a FixedThreadPool to limit the maximum number of concurrent connections and ensure efficient resource utilization. Additionally, you can use a ScheduledThreadPool to schedule periodic tasks like log rotation or cache cleanup.Types of Thread Pools:

**FixedThreadPool:**
Description: A FixedThreadPool maintains a fixed number of threads in the pool. If a task is submitted when all threads are busy, it is queued until a thread becomes available.
Use Case: Suitable for scenarios where you have a predictable number of tasks and want to limit the maximum number of concurrent threads.

**CachedThreadPool:**
Description: A CachedThreadPool dynamically adjusts the number of threads based on the workload. Threads are created as needed and reused if available. Unused threads are terminated after a specified idle timeout.
Use Case: Ideal for scenarios with a large number of short-lived tasks or when the workload varies over time.

**SingleThreadPool:**
Description: A SingleThreadPool maintains a single thread in the pool, ensuring that tasks are executed sequentially in the order they were submitted. If the thread terminates due to an exception, a new one is created to replace it.
Use Case: Useful for scenarios where tasks must be executed sequentially or when you want to decouple task execution from the main application thread.

**ScheduledThreadPool:**
Description: A ScheduledThreadPool is used for executing tasks at a specific time or with a fixed delay between executions. It maintains a pool of threads and supports scheduling tasks with methods like schedule(), scheduleAtFixedRate(), and scheduleWithFixedDelay().
Use Case: Ideal for scenarios requiring periodic execution of tasks, such as scheduling background tasks or running recurring jobs.

**Real-World Use Case Example:**
Suppose you're developing a web server application where multiple client requests need to be processed concurrently. You can use a FixedThreadPool to limit the maximum number of concurrent connections and ensure efficient resource utilization. Additionally, you can use a ScheduledThreadPool to schedule periodic tasks like log rotation or cache cleanup.

```java
// Fixed Thread Pool
// Create a FixedThreadPool with 3 threads
ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

System.out.println("\nFixed Thread Pool:");
// Submit tasks to the FixedThreadPool
for (int i = 1; i <= 5; i++) {
final int taskId = i;
    fixedThreadPool.execute(() -> {
        // Task execution
        System.out.println("Fixed Thread Task " + taskId +
        " executed by Thread: " +
        Thread.currentThread().getName());
        });
        }

// Cached Thread Pool
// Create a CachedThreadPool
ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

System.out.println("\nCached Thread Pool:");
// Submit tasks to the CachedThreadPool
for (int i = 1; i <= 5; i++) {
final int taskId = i;
    cachedThreadPool.execute(() -> {
        // Task execution
        System.out.println("Cached Thread Task " + taskId +
        " executed by Thread: " +
        Thread.currentThread().getName());
        });
        }

// Single Thread Executor
// Create a SingleThreadExecutor
ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

System.out.println("\nSingle Thread Executor:");
// Submit tasks to the SingleThreadExecutor
for (int i = 1; i <= 5; i++) {
final int taskId = i;
    singleThreadExecutor.execute(() -> {
        // Task execution
        System.out.println("Single Thread Task " + taskId +
        " executed by Thread: " +
        Thread.currentThread().getName());
        });
        }

// Scheduled Thread Pool
// Create a ScheduledThreadPool with 2 threads
ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

// Schedule a task to execute after 5 seconds
scheduledThreadPool.schedule(() ->
        System.out.println("Scheduled Task"),
        5, TimeUnit.SECONDS);

// Schedule a task to execute every 1 second, starting immediately
        scheduledThreadPool.scheduleAtFixedRate(() ->
        System.out.println("Scheduled Task"),0, 1, TimeUnit.SECONDS);

```

#### What Are Executor and Executorservice and Differences Between them?
**Executor:** It is a simple interface in Java that provides a way to decouple task submission from task execution. It defines a single method, execute(Runnable command), which executes the given command in a thread pool.

**ExecutorService:** It is a subinterface of Executor that represents a more complete version of the Executor, providing methods to manage the lifecycle of the thread pool, submit tasks for execution, and obtain Futures representing task results.

**Differences between them:**

- `Lifecycle Management:`

`Executor:` It does not provide methods for managing the lifecycle of the underlying thread pool. It only provides a way to execute tasks.

`ExecutorService:` It extends Executor and adds methods for managing the lifecycle of the thread pool, such as shutdown(), shutdownNow(), and awaitTermination().

- `Task Submission and Execution:`

Both Executor and ExecutorService provide methods to submit tasks for execution (execute(Runnable command) in Executor, submit(Runnable task) and submit(`Callable<T> task`) in ExecutorService).

- `Task Result Handling:`

`Executor:` It does not provide a way to obtain the result of a task execution directly.

`ExecutorService:` It provides methods to submit tasks that return a Future representing the result of the task execution (submit(Callable<T> task)). It also allows for task result retrieval through the Future interface.

- `Termination:`

`Executor:` It does not provide methods for terminating the thread pool.

`ExecutorService:` It provides methods to gracefully shut down the thread pool (shutdown()), forcibly shut down the thread pool (shutdownNow()), and await termination of all tasks (`awaitTermination()`).

#### Use Case Scenarios:

- Use Executor when you only need to execute tasks asynchronously without managing the thread pool's lifecycle.

- Use ExecutorService when you need more control over the thread pool, such as managing its lifecycle, submitting tasks with results, and awaiting termination.