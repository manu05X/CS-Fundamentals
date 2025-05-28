package com.manish.CoreJava.StructuralPatterns.ProxyPatternExample;

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (this.realImage == null) {
            this.realImage = new RealImage(this.fileName);
        }

        this.realImage.display();
    }
}