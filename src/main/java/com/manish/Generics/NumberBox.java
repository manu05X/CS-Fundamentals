package com.manish.Generics;

public class NumberBox<T extends Number> {
    private T content;

    public NumberBox(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }

    public double getDoubleValue() {
        return this.content.doubleValue();
    }
}