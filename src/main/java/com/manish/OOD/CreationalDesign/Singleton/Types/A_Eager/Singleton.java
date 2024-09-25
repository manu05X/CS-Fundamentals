package com.manish.OOD.CreationalDesign.Singleton.Types.A_Eager;

//public class Singleton {
//    public static final Singleton Instance = new Singleton();
//
//    private Singleton() {}
//
//    public static Singleton getInstance(){
//        System.out.println("Singleton Instance from Singleton class")   ;
//        return Instance;
//    }
//}

// With static block
public class Singleton {
    private static final Singleton Instance;

    private Singleton() {}

    static {
        try {
            Instance = new Singleton();
        } catch (Exception e) {
            throw  new RuntimeException("Exception occur during creating Singleton Instance "+e);
        }
    }

    public static Singleton getInstance(){
        System.out.println("Singleton Instance from Singleton class")   ;
        return Instance;
    }
}
