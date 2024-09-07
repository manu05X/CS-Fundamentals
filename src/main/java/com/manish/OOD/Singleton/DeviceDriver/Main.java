package com.manish.OOD.Singleton.DeviceDriver;

public class Main {
    public static void main(String[] args) {
        DeviceDriver driver = DeviceDriver.getInstance();

        // Prepare data to write
        byte[] dataToWrite = {1, 2, 3, 4, 5};

        // Write data to the device
        driver.write(dataToWrite);

        // Read data from the device
        byte[] dataRead = driver.read();

        // Print the read data
        System.out.print("Data read: ");
        for (byte b : dataRead) {
            System.out.print(b + " ");
        }
    }
}

/*
Key Features of the Completed Classes
DeviceDriver Class
Singleton Pattern
The DeviceDriver class implements the Singleton pattern to ensure only one instance exists.
Device Initialization
The constructor initializes the Device instance.
Data Operations
The write(byte[] data) method allows writing data to the device.
The read() method retrieves data from the device.
Device Class
Data Storage
The Device class uses a List<Byte> to store written data.
Write Method
The write(byte[] data) method adds bytes to the internal storage and prints the number of bytes written.
Read Method
The read() method converts the stored data back to a byte array and prints the number of bytes read.
 */