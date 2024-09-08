package com.manish.OOD.StructuralDesign.Facade.Computer;

// CPU class simulating a computer's central processing unit
public class CPU {
    public void freeze() {
        System.out.println("CPU is freezing...");
        // Implementation to freeze the CPU
    }

    public void jump(long position) {
        System.out.println("CPU is jumping to position: " + position);
        // Implementation to set the CPU's execution position
    }

    public void execute() {
        System.out.println("CPU is executing instructions...");
        // Implementation to execute instructions
    }
}
