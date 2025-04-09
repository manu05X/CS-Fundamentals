package com.manish.IO.NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class FilesExample {
    public FilesExample() {
    }

    public static void main(String[] args) {
        try {
            Path path = Paths.get("example.txt");
            List<String> lines = Files.readAllLines(path);
            Iterator var3 = lines.iterator();

            while(var3.hasNext()) {
                String line = (String)var3.next();
                System.out.println(line);
            }

            Path newPath = Paths.get("newfile.txt");
            Files.write(newPath, lines);
            System.out.println("File operations completed successfully.");
        } catch (Exception var5) {
            Exception e = var5;
            e.printStackTrace();
        }

    }
}