package com.manish.OOD.Singleton.DeviceDriver;

//public class DeviceDriver {
//}

public class DeviceDriver {
    private static volatile DeviceDriver instance;
    private Device device;

    // Private constructor to prevent instantiation
    private DeviceDriver() {
        // Initialize device
        device = new Device();
    }

    // Singleton instance retrieval
    public static DeviceDriver getInstance() {
        if (instance == null) {
            synchronized (DeviceDriver.class) {
                if (instance == null) {
                    instance = new DeviceDriver();
                }
            }
        }
        return instance;
    }

    // Method to write data to the device
    public void write(byte[] data) {
        device.write(data);
    }

    // Method to read data from the device
    public byte[] read() {
        return device.read();
    }
}

/*
//Here’s a simple implementation of the Device class that the DeviceDriver class interacts with:
import java.util.ArrayList;
import java.util.List;

class Device {
    private List<Byte> dataStorage;

    public Device() {
        dataStorage = new ArrayList<>();
    }

    // Method to write data to the device
    public void write(byte[] data) {
        for (byte b : data) {
            dataStorage.add(b);
        }
        System.out.println("Data written to device: " + data.length + " bytes.");
    }

    // Method to read data from the device
    public byte[] read() {
        byte[] data = new byte[dataStorage.size()];
        for (int i = 0; i < dataStorage.size(); i++) {
            data[i] = dataStorage.get(i);
        }
        System.out.println("Data read from device: " + data.length + " bytes.");
        return data;
    }
}
 */

/*
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
 */
