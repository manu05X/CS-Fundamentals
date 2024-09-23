package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

// Client: Demonstrates cloning the prototypes and using the cloned objects.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DocumentManager documentManager = new DocumentManager();
        //documentManager.addPrototype("memo", new Document());  // Adding an abstract prototype (not useful in this case)

        // Cloning a letter prototype and setting specific details
        Document letter = documentManager.clone("letter");
        ((Letter) letter).setRecipient("John Doe");
        ((Letter) letter).setAuthor("Jane Smith");

        // Cloning a report prototype and setting specific details
        Document report = documentManager.clone("report");
        ((Report) report).setAuthor("Bob Johnson");

        // Displaying the cloned documents' texts
        System.out.println(letter.getText());
        System.out.println(report.getText());
    }
}
