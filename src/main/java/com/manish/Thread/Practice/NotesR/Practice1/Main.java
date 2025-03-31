package com.manish.Thread.Practice.NotesR.Practice1;

//public class Main {
//    public static void main(String[] args) {
//        int count = 0;
//
//        for(int i = 0; i < 500; i++){
//            count++;
//            System.out.println("The current count is  : " +count);
//        }
//    }
//
//}

class Counter {
    int count = 0; // starting value

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

}


class MyThread extends Thread{
    private Counter counterLocal;

    // MyThread constructor
    public MyThread(Counter counter){
        this.counterLocal = counter;
    }

    @Override
    public void run() {
        System.out.println("MyThread is running : " );
        for (int i = 0; i < 300; i++){
            counterLocal.increment();// 1,2,....600
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(); // counter class ka object banega will have count = 0

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        MyThread t3 = new MyThread(counter);

        t1.start();
        t2.start();
        t3.start();

//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//        } catch (Exception e){
//            System.out.println("The Exception : "+ e);
//        }

        System.out.println(counter.getCount());
    }

}
