package com.manish.OOD.StructuralDesign.DecoratorPattern.TextEditor;

// TextEditor class to demonstrate the usage of the Decorator pattern
public class TextEditor {
    public static void main(String[] args) {
        // Create plain text
        Text text = new PlainText("Hello, world!");

        // Apply decorators
        text = new BoldText(text);
        text = new ItalicText(text);

        // Output the decorated text
        System.out.println(text.getContent()); // Outputs "<i><b>Hello, world!</b></i>"
    }
}

