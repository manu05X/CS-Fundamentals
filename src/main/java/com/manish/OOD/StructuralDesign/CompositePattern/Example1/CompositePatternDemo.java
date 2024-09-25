package com.manish.OOD.StructuralDesign.CompositePattern.Example1;

import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemComponent {
    void showDetails();
}

// Leaf
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

// Client code
public class CompositePatternDemo {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");

        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        dir1.addComponent(file1);
        dir2.addComponent(file2);
        dir1.addComponent(dir2);

        dir1.showDetails();
      
        // Directory: dir1
    	// File: file1.txt
        // Directory: dir2
        // File: file2.txt
    }
}