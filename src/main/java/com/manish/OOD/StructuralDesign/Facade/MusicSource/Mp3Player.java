package com.manish.OOD.StructuralDesign.Facade.MusicSource;

class Mp3Player implements MusicSource {
    @Override
    public void play() {
        System.out.println("Playing MP3...");
    }

    @Override
    public void pause() {
        System.out.println("Pausing MP3...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping MP3...");
    }
}
