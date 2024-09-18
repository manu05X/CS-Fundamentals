package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

public class Report extends Document {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getText() {
        String baseText = super.getText();
        return baseText.replace("[author]", author);
    }
}
