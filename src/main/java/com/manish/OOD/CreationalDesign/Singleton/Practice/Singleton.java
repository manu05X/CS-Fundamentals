package com.manish.OOD.CreationalDesign.Singleton.Practice;

//public class Singleton {
//    private static Singleton instance;
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
//
//    public void sayHello() {
//        System.out.println("Hello World!");
//    }
//}

// Double locking
public class Singleton {
    private volatile static Singleton instance;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null){
            //.class is a special syntax in Java that returns the Class object associated with the class here Singleton
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }
}
