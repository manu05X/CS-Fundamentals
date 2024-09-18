package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DocumentManager documentManager = new DocumentManager();

        Document letter = documentManager.clone("letter");
        ((Letter) letter).setRecipient("John Doe");
        ((Letter) letter).setAuthor("Jane Smith");

        Document report = documentManager.clone("report");
        ((Report) report).setAuthor("Bob Johnson");

        System.out.println("Letter:");
        System.out.println(letter.getText());

        System.out.println("\nReport:");
        System.out.println(report.getText());
    }
}
