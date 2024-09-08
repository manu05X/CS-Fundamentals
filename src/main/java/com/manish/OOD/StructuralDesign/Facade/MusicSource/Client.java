package com.manish.OOD.StructuralDesign.Facade.MusicSource;

// Client code
public class Client {
    public static void main(String[] args) {
        MusicPlayerFacade musicPlayer = new MusicPlayerFacade();

        // Play CD
        musicPlayer.playCd();
        // Pause CD
        musicPlayer.pauseCd();
        // Stop CD
        musicPlayer.stopCd();

        // Play MP3
        musicPlayer.playMp3();
        // Pause MP3
        musicPlayer.pauseMp3();
        // Stop MP3
        musicPlayer.stopMp3();

        // Play streaming music
        musicPlayer.playStreamingMusic();
        // Pause streaming music
        musicPlayer.pauseStreamingMusic();
        // Stop streaming music
        musicPlayer.stopStreamingMusic();
    }
}

