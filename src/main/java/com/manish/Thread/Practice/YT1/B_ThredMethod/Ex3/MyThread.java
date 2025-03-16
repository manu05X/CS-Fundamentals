package com.manish.Thread.Practice.YT1.B_ThredMethod.Ex3;

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {

        for(int i = 1; i < 5; i++){

            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count: " + i);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread l = new MyThread("Low Priority"); // setting the name
        MyThread m = new MyThread("Medium Priority"); // setting the name
        MyThread h = new MyThread("Highy Priority"); // setting the name

        //Its not strict but a hint to JVM so out put might not be in order but mostly in order
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);

        l.start();
        m.start();
        h.start();

    }
}
