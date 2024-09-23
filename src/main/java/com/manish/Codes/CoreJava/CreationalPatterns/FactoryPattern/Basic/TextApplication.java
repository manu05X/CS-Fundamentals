package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Basic;

// Concrete Creator Classes
public class TextApplication extends Application {
    @Override
    protected Document createDocument() {
        return new TextDocument();
    }
}

