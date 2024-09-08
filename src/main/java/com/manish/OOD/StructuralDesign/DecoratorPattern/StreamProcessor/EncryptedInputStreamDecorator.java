package com.manish.OOD.StructuralDesign.DecoratorPattern.StreamProcessor;

import java.io.IOException;
import java.io.InputStream;

// Concrete decorator class to add encryption
public class EncryptedInputStreamDecorator extends StreamDecorator {
    public EncryptedInputStreamDecorator(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public int read() throws IOException {
        int b = inputStream.read();
        if (b == -1) {
            return -1;
        }
        return b ^ 0xFF;  // Simple XOR encryption
    }
}
