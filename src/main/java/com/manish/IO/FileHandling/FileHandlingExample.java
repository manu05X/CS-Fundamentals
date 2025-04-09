package com.manish.IO.FileHandling;

import java.io.File;

public class FileHandlingExample {
    public FileHandlingExample() {
    }

    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            if (file.exists()) {
                System.out.println("File already exists.");
            } else if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("Failed to create the file.");
            }

            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File size in bytes: " + file.length());
        } catch (Exception var2) {
            Exception e = var2;
            e.printStackTrace();
        }

    }
}
