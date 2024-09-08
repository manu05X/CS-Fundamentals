package com.manish.OOD.StructuralDesign.DecoratorPattern.StreamProcessor;

import java.io.*;

public class StreamProcessor {
    public static void main(String[] args) {
        // Print the working directory to verify where the program is looking for the file
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try (InputStream inputStream = new FileInputStream("input.txt")) {
            // Decorate input stream with buffering and encryption
            InputStream bufferedStream = new BufferedInputStreamDecorator(inputStream);
            InputStream encryptedStream = new EncryptedInputStreamDecorator(bufferedStream);

            // Read and process the input stream
            int b;
            while ((b = encryptedStream.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
