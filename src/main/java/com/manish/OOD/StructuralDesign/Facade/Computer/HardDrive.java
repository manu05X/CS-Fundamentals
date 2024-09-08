package com.manish.OOD.StructuralDesign.Facade.Computer;

// HardDrive class simulating a computer's hard drive
public class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("Reading " + size + " bytes from hard drive at LBA: " + lba);
        // Implementation to read data from the hard drive
        // For simplicity, returning a dummy byte array
        return new byte[size];
    }
}
