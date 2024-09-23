package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

// Concrete Prototype: This is a concrete class extending Document, which can be cloned.
public class Letter extends Document {
    private String recipient;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    // Adding an author field to use in the clone process.
    public void setAuthor(String author) {
        // Implement author handling logic for letter
    }
}
