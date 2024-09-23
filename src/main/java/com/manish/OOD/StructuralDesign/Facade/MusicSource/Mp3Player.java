package com.manish.OOD.StructuralDesign.Facade.MusicSource;

class Mp3Player implements MusicSource {
    // Plays MP3
    public void play() {
        System.out.println("Playing MP3...");
    }

    // Pauses MP3
    public void pause() {
        System.out.println("Pausing MP3...");
    }

    // Stops MP3
    public void stop() {
        System.out.println("Stopping MP3...");
    }
}
