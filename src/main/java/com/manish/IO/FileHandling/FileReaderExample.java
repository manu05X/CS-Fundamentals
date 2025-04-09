package com.manish.IO.FileHandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public FileReaderExample() {
    }

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("example.txt");

            int character;
            while((character = reader.read()) != -1) {
                System.out.print((char)character);
            }

            reader.close();
        } catch (IOException var3) {
            IOException e = var3;
            e.printStackTrace();
        }

    }
}
