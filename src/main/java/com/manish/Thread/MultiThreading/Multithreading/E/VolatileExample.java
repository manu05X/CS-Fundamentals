package com.manish.Thread.MultiThreading.Multithreading.E;

public class VolatileExample {

    boolean flag = false;

    void threadA() {

        while (!flag) {

            // ... Do something useful
        }

    }

    void threadB() {
        flag = true;
    }
}