package com.manish.Thread.CodeQuestion.HThreadPool.SyncronizeThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTaskExample {
    public static void main(String[] args) {
        // Create a thread pool with 10 threads
        ExecutorService service = Executors.newFixedThreadPool(10);

        // Shared object to control task execution order
        TaskManager taskManager = new TaskManager();

        // Submit 100 tasks to the thread pool
        for (int i = 0; i < 100; i++) {
            service.submit(new Task(i, taskManager));
        }

        // Shutdown the executor service after all tasks are submitted
        service.shutdown();
    }
}

/*

Explanation:
Shared TaskManager:
- Manages the current task ID and ensures that tasks execute sequentially from 0 to 99.
- The executeTask method is synchronized to ensure that only one thread can check or modify the currentTask at a time.

Synchronized Execution:
- Each task waits (wait()) until its taskId matches the current expected task ID (currentTask).
- Once executed, the currentTask is incremented, and all waiting threads are notified (notifyAll()).

Task Class:
- Each task calls executeTask(taskId) from the TaskManager to ensure synchronization.

Thread Pool:
- The thread pool creates 10 threads, but the tasks execute in sequential order due to synchronization logic.


Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue. At any point, at most nThreads threads will be active processing tasks. If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available. If any thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks. The threads in the pool will exist until it is explicitly shutdown.
Params:
nThreads – the number of threads in the pool
Returns:
the newly created thread pool
Throws:
IllegalArgumentException – if nThreads <= 0

 */