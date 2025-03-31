package com.manish.Thread.Practice.NotesR.Ex3;

//class MyRunnable implements Runnable {
//    @Override
//    public void run() {
//
//        System.out.println("Thread running (implements Runnable)"); // runnable ka bbl
//    }
//}
//
//public class RunnableExample {
//    public static void main(String[] args) {
//        MyRunnable r = new MyRunnable(); // Runnable object creation -> giving memory
//        Thread thread = new Thread(r); // Thread Obj creation
//        thread.start();
//    }
//}



//class MyRunnable implements Runnable {
//    @Override
//    public void run() {
//
//        System.out.println("Thread running (implements Runnable)");
//    }
//}
//
//public class RunnableExample {
//    public static void main(String[] args) {
//
//        Thread thread = new Thread(new MyRunnable());
//        thread.start();
//    }
//}


//class MyRunnable implements Runnable {
//    @Override
//    public void run() {
//
//        System.out.println("Thread running (implements Runnable)");
//    }
//}

public class RunnableExample {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Thread running (implements Runnable)");
        });

        thread.start();
    }
}