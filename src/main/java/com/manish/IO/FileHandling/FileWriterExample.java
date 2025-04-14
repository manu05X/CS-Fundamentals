package com.manish.IO.FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public FileWriterExample() {
        // Default constructor
    }

    public static void main(String[] args) {
        try {
            // Create a FileWriter object to write to "example.txt"
            // This will create the file if it doesn't exist, or overwrite if it does
            FileWriter writer = new FileWriter("example.txt");

            // Write content to the file
            writer.write("Hello, this is an example of writing to a file.\n");  // First line
            writer.write("This is the second line.\n");  // Second line
            writer.write("This is the third line.\n");  // Third line

            // Close the writer to release system resources and ensure data is flushed
            writer.close();

            // Success message
            System.out.println("Successfully wrote to the file.");

        } catch (IOException var2) {
            // Handle potential IO exceptions (file permissions, disk full, etc.)
            IOException e = var2;
            e.printStackTrace();
        }
    }
}
