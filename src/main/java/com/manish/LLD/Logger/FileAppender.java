package com.manish.LLD.Logger;

import java.io.IOException;
import java.io.FileWriter;

public class FileAppender implements Appender{
    private FileWriter writer;

    public FileAppender(String filePath) throws IOException{
        this.writer = new FileWriter(filePath, true);
    }

    @Override
    public void append(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
