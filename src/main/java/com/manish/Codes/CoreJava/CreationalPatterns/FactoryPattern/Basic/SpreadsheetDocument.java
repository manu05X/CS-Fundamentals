package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Basic;

public class SpreadsheetDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening spreadsheet document...");
    }

    @Override
    public void save() {
        System.out.println("Saving spreadsheet document...");
    }

    @Override
    public void close() {
        System.out.println("Closing spreadsheet document...");
    }
}
