package com.manish.OOD.StructuralDesign.Facade.MusicSource;

class StreamingService implements MusicSource {
    @Override
    public void play() {
        System.out.println("Playing streaming music...");
    }

    @Override
    public void pause() {
        System.out.println("Pausing streaming music...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping streaming music...");
    }
}
