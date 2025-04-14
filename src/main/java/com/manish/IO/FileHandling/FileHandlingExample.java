package com.manish.IO.FileHandling;

import java.io.File;

public class FileHandlingExample {
    // Default constructor
    public FileHandlingExample() {
    }

    public static void main(String[] args) {
        try {
            // Create a File object representing "example.txt"
            // Note: This doesn't create physical file yet
            File file = new File("example.txt");

            // Check if file exists
            if (file.exists()) {
                System.out.println("File already exists.");
            }
            // Attempt to create new file if it doesn't exist
            else if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
            // Handle case when file creation fails
            else {
                System.out.println("Failed to create the file.");
            }

            // Display file properties
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File size in bytes: " + file.length());

        } catch (Exception var2) {
            // Handle exceptions (security, IO errors, etc.)
            Exception e = var2;
            e.printStackTrace();
        }
    }
}

/*


public static void main(String[] args) {
    // Using Paths.get() for better path handling (Java 7+)
    Path path = Paths.get("example.txt");

    try {
        if (Files.exists(path)) {
            System.out.println("File already exists.");
        } else {
            Files.createFile(path);
            System.out.println("File created: " + path.getFileName());
        }

        // Modern way to get file attributes
        System.out.println("File name: " + path.getFileName());
        System.out.println("Absolute path: " + path.toAbsolutePath());
        System.out.println("Writable: " + Files.isWritable(path));
        System.out.println("Readable: " + Files.isReadable(path));
        System.out.println("File size: " + Files.size(path) + " bytes");

    } catch (IOException e) {
        e.printStackTrace();
    }
}
 */