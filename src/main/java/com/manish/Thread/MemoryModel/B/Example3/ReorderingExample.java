package com.manish.Thread.MemoryModel.B.Example3;

public class ReorderingExample {

    int x = 0;

    // executed by thread1
    void method1() {
        int read1 = x;
        x = 1;
    }

    // executed by thread2
    void method2(){
        int read2 = x;
        x = 2;
    }
}