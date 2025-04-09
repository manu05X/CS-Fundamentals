package com.manish.IO.NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public PathExample() {
    }

    public static void main(String[] args) {
        Path path = Paths.get("/Users/manishkumar/Desktop/Java-Fundamentals/src/main/java/com/manish/NIO/example.txt");
        System.out.println("Filename: " + String.valueOf(path.getFileName()));
        System.out.println("Parent directory: " + String.valueOf(path.getParent()));
        System.out.println("Root component: " + String.valueOf(path.getRoot()));
        System.out.println("Number of name elements in path: " + path.getNameCount());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute path: " + String.valueOf(absolutePath));
    }
}