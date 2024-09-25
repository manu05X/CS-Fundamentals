package com.manish.OOD.CreationalDesign.Singleton.Types.B_Lazy;

public class Main {
    public static void main(String[] args) {
        lazySingleton s1 = lazySingleton.getInstance();

        System.out.println(s1);

        lazySingleton s2 = lazySingleton.getInstance();
        System.out.println(s2==s1);

    }
}
