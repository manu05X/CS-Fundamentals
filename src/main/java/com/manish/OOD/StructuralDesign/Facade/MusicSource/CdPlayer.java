package com.manish.OOD.StructuralDesign.Facade.MusicSource;

// Concrete subsystems
class CdPlayer implements MusicSource {
    @Override
    public void play() {
        System.out.println("Playing CD...");
    }

    @Override
    public void pause() {
        System.out.println("Pausing CD...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping CD...");
    }
}
