package com.manish.Thread.Practice.NotesR.Ex1;

/*
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread[] threads = new Thread[1000];

        for(int i = 0; i < 1000; i++){
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }

        for(int i = 0; i < 1000; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("FInal Count:" +counter.getCount()); // Might be less than 1000

    }
}

 */
/*
1. Visibility Issues:
• Without volatile, threads may not see the most recent value of count
• Threads might use a cached value, leading to incorrect results
2. Race Conditions:
• count++ is not atomic
• Multiple threads can read the same value simultaneously, causing lost updates

Since count++ is not an atomic operation, it consists of multiple steps (read-modify-write), which can lead to race conditions
1. Read the current value of count
2. Increment the value
3. Write the new value back to count
Since these steps are not executed as a single, atomic operation, other threads can interfere at any point. This can cause inconsistencies or errors, such as multiple threads reading the same value before any of them write back the incremented value, which can result in lost updates

Lets say you used volatile keyword, then also, the final count may be less thar 1000 due to the race condition
Race condition came because count++ is not atomic operation (we discussed above)

To avoid the potential issues discussed with the volatile keyword and the race condition in the counter example, you need to ensure that the increment operation is atomic. Here are a few approaches to achieve this:
1. Using synchronized Method or Block
2. Using AtomicInteger

While the volatile keyword ensures visibility, it does not ensure atomicity.
The synchronized keyword ensures both atomicity and visibility
Hence we have only used Synchronized in below example



*/

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(); // synchronized Counter

        Thread[] threads = new Thread[1000];

        for(int i = 0; i < 1000; i++){
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }

        for(int i = 0; i < 1000; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("FInal Count:" +counter.getCount()); // Might be less than 1000

    }
}
