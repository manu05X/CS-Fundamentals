package com.manish.OOD.CreationalDesign.Singleton.Types.C_ThreadSafe;

public class Singleton {
    private static Singleton INSTANCE = null;
    private Singleton() {}

    static int count = 0;
    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
            count++;

            System.out.println("Creating Singleton instance count: " + count);
        }
        return INSTANCE;
    }
}
