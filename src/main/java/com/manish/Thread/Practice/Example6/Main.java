package com.manish.Thread.Practice.Example6;

/*
public class Main {
    private static final int PRINT_COUNT = 5;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    System.out.println("Hello");
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < PRINT_COUNT; i++){
                    System.out.println("World");
                }
            }
        });


        t1.start();
        t2.start();
    }
}
*/


/*
public class Main {
    private static final int PRINT_COUNT = 5;
    private static final Object lock = new Object();
    private static boolean printHello = true; // Control flag

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    synchronized (lock) {
                        // Wait until it's Hello's turn
                        while (!printHello) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                        System.out.println("Hello");
                        printHello = false;
                        lock.notifyAll(); // Notify the other thread
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    synchronized (lock) {
                        // Wait until it's World's turn
                        while (printHello) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                        System.out.println("World");
                        printHello = true;
                        lock.notifyAll(); // Notify the other thread
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
*/




public class Main {
    private static final int PRINT_COUNT = 5;
    private static final Object lock = new Object();
    private static int counter = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (lock) {
                    System.out.println("Hello");
                    //counter++;
                    lock.notify();
                    try {
                        if (i < PRINT_COUNT - 1) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (lock) {
                    System.out.println("World");
                    //counter++;
                    lock.notify();
                    try {
                        if (i < PRINT_COUNT - 1) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}