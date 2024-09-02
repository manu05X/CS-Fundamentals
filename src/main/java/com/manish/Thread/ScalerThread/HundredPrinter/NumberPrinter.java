package com.manish.Thread.ScalerThread.HundredPrinter;

public class NumberPrinter implements Runnable{
    private int numberToPrint;

    public NumberPrinter(int num){
        this.numberToPrint = num;
    }

    public void run(){
        System.out.println(numberToPrint + " --> Printed By: Thread# " + Thread.currentThread().getName());
    }
}


/*
We should not use global variable i.e static as it may print same number
many times as each thread works independently so they are unaware of each other
so printing same number many times
* */
/*
public class NumberPrinter implements Runnable{
    public static int nextNumberToPrint = 1;
    public NumberPrinter(){

    }

    public void run(){
        //System.out.println(numberToPrint + " --> Printed By: Thread# " + Thread.currentThread().getName());
        System.out.println(nextNumberToPrint);
        nextNumberToPrint += 1;
    }
}*/

/*
public class NumberPrinter extends Thread{
    private int numberToPrint;

    public NumberPrinter(int num){
        this.numberToPrint = num;
    }

    public void run(){
        System.out.println(numberToPrint + " --> Printed By: Thread# " + Thread.currentThread().getName());
    }
}
*/