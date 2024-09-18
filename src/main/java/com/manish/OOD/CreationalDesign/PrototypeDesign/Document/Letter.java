package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

public class Letter extends Document {
    private String recipient;
    private String author;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getText() {
        String baseText = super.getText();
        return baseText.replace("[recipient]", recipient).replace("[author]", author);
    }
}
