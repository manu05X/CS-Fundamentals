package com.manish.Thread.Practice.Example5;

/*
class Counter{
    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class MyThread extends Thread{
    private Counter counter;

    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("MyThread is running : " );
        for (int i = 0; i < 100; i++){
            counter.increment();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        MyThread t3 = new MyThread(counter);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e){
            System.out.println("The Exception : "+ e);
        }

        System.out.println(counter.getCount());
    }
}
*/


/*
class SharedCounter{
    private int count = 1;
    private final int MAX = 100;

    public synchronized void printNumber(){
        while (count <= MAX){
            System.out.println(Thread.currentThread().getName() + " : "+count);
            count++;

            try {
                Thread.sleep(10); // Simulate a small delay
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class MyThread extends Thread{
    private final SharedCounter counter;

    public MyThread(SharedCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        counter.printNumber();
    }
}

public class Main {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        MyThread t3 = new MyThread(counter);

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();

//        try{
//            t1.join();
//            t2.join();
//            t3.join();
//        } catch (Exception e){
//            System.out.println("The Exception : "+ e);
//        }
    }
}
*/

/*
class SharedCounter {
    private int count = 1;
    private final int MAX = 100;

    public synchronized void printNumbers() {
        while (count <= MAX) {
            System.out.println(Thread.currentThread().getName() + " : " + count);
            count++;
            try {
                Thread.sleep(10); // Simulate a small delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class MyThread extends Thread {
    private final SharedCounter counter;

    public MyThread(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.printNumbers();
    }
}

public class Main {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        MyThread t3 = new MyThread(counter);

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
*/


/*
Thread-1 : 1
Thread-1 : 2
Thread-1 : 3
Thread-1 : 4
Thread-1 : 5
Thread-1 : 6
Thread-1 : 7
Thread-1 : 8
Thread-1 : 9
Thread-1 : 10
Thread-1 : 11
Thread-1 : 12
Thread-1 : 13
Thread-1 : 14
Thread-1 : 15
Thread-1 : 16
Thread-1 : 17
Thread-1 : 18
Thread-1 : 19
Thread-1 : 20
Thread-1 : 21
Thread-1 : 22
Thread-1 : 23
Thread-1 : 24
Thread-1 : 25
Thread-1 : 26
Thread-1 : 27
Thread-1 : 28
Thread-1 : 29
Thread-1 : 30
Thread-1 : 31
Thread-1 : 32
Thread-1 : 33
Thread-1 : 34
Thread-1 : 35
Thread-1 : 36
Thread-1 : 37
Thread-1 : 38
Thread-1 : 39
Thread-1 : 40
Thread-1 : 41
Thread-1 : 42
Thread-1 : 43
Thread-1 : 44
Thread-1 : 45
Thread-1 : 46
Thread-1 : 47
Thread-1 : 48
Thread-1 : 49
Thread-1 : 50
Thread-1 : 51
Thread-1 : 52
Thread-1 : 53
Thread-1 : 54
Thread-1 : 55
Thread-1 : 56
Thread-1 : 57
Thread-1 : 58
Thread-1 : 59
Thread-1 : 60
Thread-1 : 61
Thread-1 : 62
Thread-1 : 63
Thread-1 : 64
Thread-1 : 65
Thread-1 : 66
Thread-1 : 67
Thread-1 : 68
Thread-1 : 69
Thread-1 : 70
Thread-1 : 71
Thread-1 : 72
Thread-1 : 73
Thread-1 : 74
Thread-1 : 75
Thread-1 : 76
Thread-1 : 77
Thread-1 : 78
Thread-1 : 79
Thread-1 : 80
Thread-1 : 81
Thread-1 : 82
Thread-1 : 83
Thread-1 : 84
Thread-1 : 85
Thread-1 : 86
Thread-1 : 87
Thread-1 : 88
Thread-1 : 89
Thread-1 : 90
Thread-1 : 91
Thread-1 : 92
Thread-1 : 93
Thread-1 : 94
Thread-1 : 95
Thread-1 : 96
Thread-1 : 97
Thread-1 : 98
Thread-1 : 99
Thread-1 : 100



 */


class SharedCounter {
    private int count = 1;
    private final int MAX = 100;

    public synchronized void printNumbers() {
        while (count <= MAX) {
            System.out.println(Thread.currentThread().getName() + " : " + count);
            count++;

            notifyAll(); // Notify all waiting threads
            try {
                //Thread.sleep(10); // Simulate a small delay
                if (count <= MAX) {
                    wait(); // Release lock and wait for the next turn
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class MyThread extends Thread {
    private final SharedCounter counter;

    public MyThread(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.printNumbers();
    }
}

public class Main {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        MyThread t3 = new MyThread(counter);

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*

package com.manish.Thread.Practice.Example5;

class SharedCounter {
    private int count = 1;
    private final int MAX = 100;

    public synchronized void printNumbers() {
        while (count <= MAX) {
            System.out.println(Thread.currentThread().getName() + " : " + count);
            count++;

            notifyAll(); // Notify all waiting threads

            try {
                if (count <= MAX) {
                    wait(); // Release lock and wait for the next turn
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class MyRunnable implements Runnable {
    private final SharedCounter counter;

    public MyRunnable(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.printNumbers();
    }
}

public class Main {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        Thread t1 = new Thread(new MyRunnable(counter), "Thread-1");
        Thread t2 = new Thread(new MyRunnable(counter), "Thread-2");
        Thread t3 = new Thread(new MyRunnable(counter), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

 */