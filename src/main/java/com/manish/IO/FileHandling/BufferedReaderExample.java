package com.manish.IO.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    // Default constructor
    public BufferedReaderExample() {
    }

    public static void main(String[] args) {
        try {
            // Create a FileReader to read from "example.txt"
            FileReader fileReader = new FileReader("example.txt");

            // Wrap FileReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read file line by line until end of file (null is returned)
            while((line = bufferedReader.readLine()) != null) {
                // Print each line to console
                System.out.println(line);
            }

            // Close resources (should be in finally block in production code)
            bufferedReader.close();
            fileReader.close();

        } catch (IOException var4) {
            // Handle IO exceptions (file not found, permission issues, etc.)
            IOException e = var4;
            e.printStackTrace();
        }
    }
}

/*

Key Components Explained
BufferedReader Advantages:

Wraps a Reader (like FileReader) to buffer input

Reads chunks of data at once (better performance)

Provides readLine() method for convenient line-by-line reading

Reading Process:

readLine() returns null when end of file is reached

Each line includes content but excludes line terminators

Much more efficient than character-by-character reading

Resource Handling:

Resources should ideally be closed in a finally block

Close the outermost wrapper (BufferedReader) first

Modern approach would use try-with-resources
 */