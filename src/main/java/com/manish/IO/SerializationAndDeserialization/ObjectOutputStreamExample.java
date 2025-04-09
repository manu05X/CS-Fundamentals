package com.manish.IO.SerializationAndDeserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamExample {
    public ObjectOutputStreamExample() {
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        try {
            FileOutputStream fileOut = new FileOutputStream("names.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(names);
            objectOut.close();
            System.out.println("List of names serialized successfully.");
        } catch (IOException var4) {
            IOException e = var4;
            e.printStackTrace();
        }

    }
}
