package com.manish.OOD.StructuralDesign.Facade.Computer;

// Computer class that uses CPU, Memory, and HardDrive to start up the system
public class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        System.out.println("Starting computer...");
        cpu.freeze();
        byte[] data = hardDrive.read(0, 100);
        memory.load(0, data);
        cpu.jump(0);
        cpu.execute();
        System.out.println("Computer started.");
    }
}
