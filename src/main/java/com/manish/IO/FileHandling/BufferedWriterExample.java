package com.manish.IO.FileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public BufferedWriterExample() {
    }

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            String filename = "example.txt";
            fileWriter = new FileWriter(filename, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("This is an example of writing to a file using BufferedWriter.\n");
            bufferedWriter.write("BufferedWriter is used to provide efficient writing of characters.\n");
            bufferedWriter.flush();
            System.out.println("Successfully wrote to the file using BufferedWriter.");
        } catch (IOException var12) {
            IOException e = var12;
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException var11) {
                IOException e = var11;
                e.printStackTrace();
            }

        }

    }
}
