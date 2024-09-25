package com.manish.OOD.CreationalDesign.FactoryDesign.FactoryMethod.Basic;

public class SpreadsheetApplication extends Application {
    @Override
    protected Document createDocument() {
        return new SpreadsheetDocument();
    }
}
