package com.manish.IO.FileHandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public FileReaderExample() {
        // Default constructor
    }

    public static void main(String[] args) {
        try {
            // Create a FileReader object to read from "example.txt"
            // The file must exist or this will throw FileNotFoundException
            FileReader reader = new FileReader("example.txt");

            int character;  // Stores each character read (as an int)

            // Read characters one by one until end of file (-1)
            while((character = reader.read()) != -1) {
                // Convert the integer to a char and print it
                System.out.print((char)character);
            }

            // Close the reader to release system resources
            reader.close();

        } catch (IOException var3) {
            // Handle potential IO exceptions (file not found, permission issues, etc.)
            IOException e = var3;
            e.printStackTrace();
        }
    }
}


/*


Key Components Explained
FileReader Class:

Used for reading character streams from files

Reads one character at a time (inefficient for large files)

Returns -1 when end of file is reached

Reading Process:

reader.read(): Reads a single character (returns int)

The loop continues until -1 (end of file) is returned

Each character is cast to char before printing

Exception Handling:

Wrapped in try-catch block to handle IOException

Common exceptions: file not found, permission issues

Important Notes:

Reads raw bytes and converts them to characters using default encoding

For better performance with large files, consider buffering

Always close file resources to prevent memory leaks
 */