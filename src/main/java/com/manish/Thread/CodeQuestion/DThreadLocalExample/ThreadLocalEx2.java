package com.manish.Thread.CodeQuestion.DThreadLocalExample;

public class ThreadLocalEx2 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
//        threadLocal.set(100); // will result in null

        Thread thread = new Thread(()->{
            threadLocal.set(100);
            System.out.println("The new Updated Value of threadLocal variable : " +threadLocal.get());
        });

        thread.start();
    }
}
