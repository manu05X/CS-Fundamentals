package com.manish.OOD.CreationalDesign.Singleton.Types.D_DoubleLock;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                if (instance == null) {
                    instance = new Singleton();
                    System.out.println("Singleton instance created by " + Thread.currentThread().getName());
                }
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " found the instance already created.");
        }
        return instance;
    }
}
