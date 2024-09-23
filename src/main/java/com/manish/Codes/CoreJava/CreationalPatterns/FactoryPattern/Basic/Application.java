package com.manish.Codes.CoreJava.CreationalPatterns.FactoryPattern.Basic;

// Creator Class
public abstract class Application {
    // Factory method
    protected abstract Document createDocument();

    // Other methods using the product
    public void newDocument() {
        Document doc = createDocument();
        doc.open();
        // More operations...
    }
}