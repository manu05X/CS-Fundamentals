package com.manish.Thread.MultiThreading.Basic._8CriticalSection.Example1;

public class Demonstration {
    public Demonstration() {
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition.runTest();
    }
}

/*
Example Thread Race
The below program spawns two threads. One thread prints the value of a shared variable whenever the shared variable is divisible by 5. A race condition happens when the printer thread executes a test-then-act if clause, which checks if the shared variable is divisible by 5 but before the thread can print the variable out, its value is changed by the modifier thread. Some of the printed values aren’t divisible by 5 which verifies the existence of a race condition in the code.


Even though the if condition on line 19 makes a check for a value which is divisible by 5 and only then prints randInt. It is just after the if check and before the print statement i.e. in-between lines 19 and 21, that the value of randInt is modified by the modifier thread! This is what constitutes a race condition.



 */