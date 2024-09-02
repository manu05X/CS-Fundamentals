package com.manish.Thread.MemoryModel.B.Example2;

class ReorderingExample {

    static class MyObject {
        int x;
    }

    // shared variables
    MyObject obj1;
    MyObject obj2;


    // executed by thread1
    void method1() {

        MyObject read1 = obj1;
        int read2 = read1.x;
        MyObject read3 = obj2;
        int read4 = read3.x;
        int read5 = read1.x;
    }

    // executed by thread2
    void method2() {
        MyObject read6 = obj1;
        read6.x = 3;
    }
}