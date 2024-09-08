package com.manish.OOD.StructuralDesign.DecoratorPattern.StreamProcessor;

import java.io.IOException;
import java.io.InputStream;

// Concrete decorator class to add buffering
public class BufferedInputStreamDecorator extends StreamDecorator {
    private static final int BUFFER_SIZE = 1024;
    private byte[] buffer = new byte[BUFFER_SIZE];
    private int bufferLength = 0;
    private int bufferPosition = 0;

    public BufferedInputStreamDecorator(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public int read() throws IOException {
        if (bufferPosition >= bufferLength) {
            fillBuffer();
            if (bufferLength == -1) {
                return -1;
            }
            bufferPosition = 0;
        }
        return buffer[bufferPosition++] & 0xFF;
    }

    private void fillBuffer() throws IOException {
        bufferLength = inputStream.read(buffer);
    }
}
