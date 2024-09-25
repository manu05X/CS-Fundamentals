package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Basic;

// Concrete Creator Classes
public class TextApplication extends Application {
    @Override
    protected Document createDocument() {
        return new TextDocument();
    }
}

