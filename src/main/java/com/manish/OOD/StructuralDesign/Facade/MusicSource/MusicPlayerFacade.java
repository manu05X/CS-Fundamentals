package com.manish.OOD.StructuralDesign.Facade.MusicSource;

// Facade class
class MusicPlayerFacade {
    private MusicSource cdPlayer;
    private MusicSource mp3Player;
    private MusicSource streamingService;

    // Constructor initializing the subsystems
    public MusicPlayerFacade() {
        this.cdPlayer = new CdPlayer();
        this.mp3Player = new Mp3Player();
        this.streamingService = new StreamingService();
    }

    // Simplified method to play CD using the facade
    public void playCd() {
        cdPlayer.play();
    }

    // Simplified method to pause CD using the facade
    public void pauseCd() {
        cdPlayer.pause();
    }

    // Simplified method to stop CD using the facade
    public void stopCd() {
        cdPlayer.stop();
    }

    // Simplified method to play MP3 using the facade
    public void playMp3() {
        mp3Player.play();
    }

    // Simplified method to pause MP3 using the facade
    public void pauseMp3() {
        mp3Player.pause();
    }

    // Simplified method to stop MP3 using the facade
    public void stopMp3() {
        mp3Player.stop();
    }

    // Simplified method to play streaming music using the facade
    public void playStreamingMusic() {
        streamingService.play();
    }

    // Simplified method to pause streaming music using the facade
    public void pauseStreamingMusic() {
        streamingService.pause();
    }

    // Simplified method to stop streaming music using the facade
    public void stopStreamingMusic() {
        streamingService.stop();
    }
}
