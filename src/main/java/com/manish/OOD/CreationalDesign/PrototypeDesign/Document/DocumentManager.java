package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

import java.util.HashMap;
import java.util.Map;

// Client: Manages prototypes and uses the clone method to create copies of them.
public class DocumentManager {
    private Map<String, Document> prototypes = new HashMap<>();

    public DocumentManager() {
        // Preloading prototype objects
        Letter letter = new Letter();
        letter.setText("Dear [recipient],\n\nSincerely,\n[author]");
        prototypes.put("letter", letter);

        Report report = new Report();
        report.setText("This is a report written by [author]");
        prototypes.put("report", report);
    }

    // Adding a prototype
    public void addPrototype(String key, Document prototype) {
        prototypes.put(key, prototype);
    }

    // Removing a prototype
    public void removePrototype(String key) {
        prototypes.remove(key);
    }

    // Cloning the prototype object
    public Document clone(String key) throws CloneNotSupportedException {
        return (Document) prototypes.get(key).clone();
    }
}
