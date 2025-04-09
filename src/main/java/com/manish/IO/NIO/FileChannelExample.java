package com.manish.IO.NIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExample {
    public FileChannelExample() {
    }

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("example.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Hello, FileChannel!".getBytes());
            buffer.flip();

            while(buffer.hasRemaining()) {
                channel.write(buffer);
            }

            channel.close();
            file.close();
        } catch (Exception var4) {
            Exception e = var4;
            e.printStackTrace();
        }

    }
}