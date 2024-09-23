package com.manish.OOD.StructuralDesign.Facade.HomeTheater;

// Facade for Home Theater System
public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Projector projector;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Projector projector) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        dvdPlayer.on();
        amplifier.on();
        amplifier.setSurroundSound();
        projector.on();
        projector.setInput("DVD");
        dvdPlayer.play(movie);
    }

    // Other simplified methods...
}
