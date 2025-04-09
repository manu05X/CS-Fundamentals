package com.manish.IO.FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public FileWriterExample() {
    }

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, this is an example of writing to a file.\n");
            writer.write("This is the second line.\n");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException var2) {
            IOException e = var2;
            e.printStackTrace();
        }

    }
}
