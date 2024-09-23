package com.manish.OOD.StructuralDesign.Facade.HomeTheater;

// Client Code
public class Client {
    public static void main(String[] args) {
        // Create subsystem objects
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();

        // Create facade for home theater system
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector);

        // Use the facade to watch a movie
        homeTheater.watchMovie("Inception");
    }
}
