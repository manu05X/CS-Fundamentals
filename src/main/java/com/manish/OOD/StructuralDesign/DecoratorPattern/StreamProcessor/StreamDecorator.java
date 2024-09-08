package com.manish.OOD.StructuralDesign.DecoratorPattern.StreamProcessor;

import java.io.IOException;
import java.io.InputStream;

// Abstract decorator class for InputStream
public abstract class StreamDecorator extends InputStream {
    protected InputStream inputStream;

    public StreamDecorator(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
