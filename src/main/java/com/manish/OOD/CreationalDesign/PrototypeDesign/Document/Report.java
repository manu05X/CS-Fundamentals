package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

// Concrete Prototype: Another concrete class that implements cloning.
public class Report extends Document {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
