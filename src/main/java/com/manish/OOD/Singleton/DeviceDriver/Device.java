package com.manish.OOD.Singleton.DeviceDriver;

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
