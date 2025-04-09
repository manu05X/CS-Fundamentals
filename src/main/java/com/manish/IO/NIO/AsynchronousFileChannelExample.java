package com.manish.IO.NIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelExample {
    public AsynchronousFileChannelExample() {
    }

    public static void main(String[] args) {
        try {
            Path path = Paths.get("example.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long position = 0L;
            Future<Integer> operation = channel.read(buffer, position);

            while(true) {
                if (operation.isDone()) {
                    buffer.flip();
                    position = 0L;
                    Future<Integer> writeOperation = channel.write(buffer, position);

                    while(!writeOperation.isDone()) {
                    }

                    channel.close();
                    System.out.println("File operations completed successfully.");
                    break;
                }
            }
        } catch (Exception var8) {
            Exception e = var8;
            e.printStackTrace();
        }

    }
}
