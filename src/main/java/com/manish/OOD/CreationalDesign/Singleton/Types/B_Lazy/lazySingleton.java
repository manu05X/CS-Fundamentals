package com.manish.OOD.CreationalDesign.Singleton.Types.B_Lazy;

public class lazySingleton {
    private static lazySingleton INSTANCE = null;
    private lazySingleton() {}

    public static lazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new lazySingleton();
            System.out.println("lazy singleton created ");
        }

        return INSTANCE;
    }
}
