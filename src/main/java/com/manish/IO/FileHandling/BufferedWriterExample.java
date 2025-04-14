package com.manish.IO.FileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public BufferedWriterExample() {
        // Default constructor
    }

    public static void main(String[] args) {
        // Declare resources outside try block for proper cleanup in finally
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            String filename = "example1.txt";

            // Create a FileWriter (false = overwrite existing file)
            fileWriter = new FileWriter(filename, false);

            // Wrap FileWriter with BufferedWriter for better performance
            bufferedWriter = new BufferedWriter(fileWriter);

            // Write content to the file (buffered)
            bufferedWriter.write("This is an example of writing to a file using BufferedWriter.\n");
            bufferedWriter.write("BufferedWriter is used to provide efficient writing of characters.\n");

            // Flush the buffer to ensure data is written to disk
            bufferedWriter.flush();

            System.out.println("Successfully wrote to the file using BufferedWriter.");

        } catch (IOException var12) {
            // Handle IO exceptions (permission issues, disk full, etc.)
            IOException e = var12;
            e.printStackTrace();
        } finally {
            // Proper resource cleanup in finally block
            try {
                // Close BufferedWriter first (it will flush any remaining data)
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

                // Then close FileWriter
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException var11) {
                IOException e = var11;
                e.printStackTrace();
            }
        }
    }
}

/*

Constructs a FileWriter given a file name and a boolean indicating whether to append the data written, using the default charset.
Params:
fileName – String The system-dependent filename.
append – boolean if true, then data will be written to the end of the file rather than the beginning.


Key Components Explained
BufferedWriter Benefits:

Wraps a Writer (like FileWriter) to buffer output

Reduces number of physical I/O operations by writing in chunks

Provides newLine() method for platform-independent line endings

FileWriter Parameters:

filename: The file to write to

false: Overwrite mode (use true to append to existing file)

Important Methods:

write(): Writes text to the buffer

flush(): Forces any buffered output to be written

close(): Flushes and closes the stream (automatically calls flush())

Resource Management:

Resources declared outside try block for proper cleanup

Cleaned up in reverse order of creation

Nested try-catch in finally block for close operations


 */