package com.manish.OOD.StructuralDesign.Facade.MusicSource;

class StreamingService implements MusicSource {
    // Plays streaming music
    public void play() {
        System.out.println("Playing streaming music...");
    }

    // Pauses streaming music
    public void pause() {
        System.out.println("Pausing streaming music...");
    }

    // Stops streaming music
    public void stop() {
        System.out.println("Stopping streaming music...");
    }
}
