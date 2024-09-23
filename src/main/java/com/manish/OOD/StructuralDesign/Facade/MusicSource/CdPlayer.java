package com.manish.OOD.StructuralDesign.Facade.MusicSource;

// Concrete subsystems
class CdPlayer implements MusicSource {
    // Plays the CD
    public void play() {
        System.out.println("Playing CD...");
    }

    // Pauses the CD
    public void pause() {
        System.out.println("Pausing CD...");
    }

    // Stops the CD
    public void stop() {
        System.out.println("Stopping CD...");
    }
}
