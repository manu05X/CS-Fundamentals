package com.manish.IO.NIO;

import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Iterator;

public class WatchServiceExample {
    public static void main(String[] args) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            // Updated path for macOS
            Path directory = Paths.get("/Users/manishkumar/Desktop/Java-Fundamentals/src/main/java/com/manish/NIO");

            // Register for all event types
            directory.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Watching directory: " + directory);

            while(true) {
                WatchKey key = watchService.take();
                Iterator<WatchEvent<?>> events = key.pollEvents().iterator();

                while(events.hasNext()) {
                    WatchEvent<?> event = events.next();
                    System.out.println("Event kind: " + event.kind() +
                            ". File affected: " + event.context() + ".");
                }

                boolean valid = key.reset();
                if (!valid) {
                    System.out.println("Key has been unregistered");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}