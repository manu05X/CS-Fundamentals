package com.manish.OOD.StructuralDesign.Facade.MusicSource;

// Client code
public class Client {
    public static void main(String[] args) {
        // Creating facade for music player system
        MusicPlayerFacade musicPlayer = new MusicPlayerFacade();

        // Using the facade to play CD
        musicPlayer.playCd();

        // Using the facade to play MP3
        musicPlayer.playMp3();

        // Using the facade to play streaming music
        musicPlayer.playStreamingMusic();
    }
}
