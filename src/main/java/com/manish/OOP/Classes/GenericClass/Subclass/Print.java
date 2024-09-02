package com.manish.OOP.Classes.GenericClass.Subclass;

public class Print<T> {
    T value;

    public Print() {
    }

    public Object getPrintValue() {
        return this.value;
    }

    public void setPrintValue(T value) {
        this.value = value;
    }
}
