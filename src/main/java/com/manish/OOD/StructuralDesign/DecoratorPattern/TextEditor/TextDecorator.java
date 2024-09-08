package com.manish.OOD.StructuralDesign.DecoratorPattern.TextEditor;

// Abstract TextDecorator class implements the Text interface
public abstract class TextDecorator implements Text {
    private Text text;

    public TextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text.getContent();
    }
}
