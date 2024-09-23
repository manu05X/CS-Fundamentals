package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Basic;

public class SpreadsheetApplication extends Application {
    @Override
    protected Document createDocument() {
        return new SpreadsheetDocument();
    }
}
