package com.manish.Thread.ScalerThread.threads;

// lombok library
//import lombok.AllArgsConstructor;

//public class SquarePrinter implements Runnable{
public class SquarePrinter extends Thread{
    // refrence for the number
    private Integer number;
/*

//    public SquarePrinter(Integer number){
//        this.number = number;
    }
    using (command + N) we can geneurate constructor automatically
*/
    public SquarePrinter(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        //create a constructor to pass the number to squarePrinter
        System.out.println(number * number + " Printed by " + Thread.currentThread().getName());
    }
}

/*
//implements Runnable
package main.ScalerThread.threads;
//public class SquarePrinter implements Runnable{
    private Integer number;

    public SquarePrinter(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        //create a constructor to pass the number to squarePrinter
        System.out.println(number * number + " Printed by " + Thread.currentThread().getName());
    }
}
 */