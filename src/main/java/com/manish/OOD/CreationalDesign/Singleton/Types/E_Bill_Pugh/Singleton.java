package com.manish.OOD.CreationalDesign.Singleton.Types.E_Bill_Pugh;

public class Singleton {

    private Singleton(){}
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
