package com.manish.IO.SerializationAndDeserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public SerializationExample() {
    }

    public static void main(String[] args) {
        Student student = new Student("John Doe", 20);

        try {
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(student);
            objectOut.close();
            System.out.println("Student object serialized successfully.");
        } catch (IOException var4) {
            IOException e = var4;
            e.printStackTrace();
        }

    }
}
