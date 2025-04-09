package com.manish.IO.SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public DeserializationExample() {
    }

    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Student student = (Student)objectIn.readObject();
            objectIn.close();
            System.out.println("Deserialized Student:");
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
        } catch (ClassNotFoundException | IOException var4) {
            Exception e = var4;
            ((Exception)e).printStackTrace();
        }

    }
}
