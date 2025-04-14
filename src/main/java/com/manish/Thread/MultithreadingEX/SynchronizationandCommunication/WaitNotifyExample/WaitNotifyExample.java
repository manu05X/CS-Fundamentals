package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.WaitNotifyExample;


public class WaitNotifyExample {
    public WaitNotifyExample() {
    }

    public static void main(String[] args) {
        Message msg = new Message();

        Thread producer = new Thread(() -> {
            msg.produce("Hello, World!");
        });

        Thread consumer = new Thread(() -> {
            msg.consume();
        });

        consumer.start();
        producer.start();
    }
}

/*

Key Points About Wait/Notify
Synchronization Required: Both wait() and notify() must be called from synchronized blocks/methods (as you've done correctly)

Order Matters: If the producer calls notify() before the consumer calls wait(), the notification is lost (this is why starting the consumer first is important in your example)

Alternative: Consider using higher-level concurrency utilities from java.util.concurrent package (like BlockingQueue) which are less error-prone.



If We Remove notify() in Producer
If you remove the notify() call from the producer method, the program behavior changes dramatically:

Expected Behavior:
    The consumer thread will start and wait indefinitely at wait()
    The producer thread will set the message but won't notify the consumer
    The program will hang forever, with the consumer thread stuck in waiting state

Why This Happens:
1. wait() Behavior: When a thread calls wait(), it:

    Releases the lock
    Goes into a waiting state
    Won't wake up until either:
        Another thread calls notify() or notifyAll()
        The thread is interrupted
        A spurious wakeup occurs (rare)

2. Without notify(): There's no mechanism to wake up the waiting consumer thread, so it remains blocked indefinitely.
 */