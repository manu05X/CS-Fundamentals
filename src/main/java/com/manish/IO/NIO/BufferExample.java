package com.manish.IO.NIO;

import java.nio.IntBuffer;

public class BufferExample {
    public BufferExample() {
    }

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(5);

        for(int i = 1; i <= buffer.capacity(); ++i) {
            buffer.put(i * 2);
        }

        buffer.flip();

        while(buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

    }
}