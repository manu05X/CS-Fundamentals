package com.manish.OOD.StructuralDesign.Facade.MusicSource;

// Facade class
class MusicPlayerFacade {
    private MusicSource cdPlayer;
    private MusicSource mp3Player;
    private MusicSource streamingService;

    public MusicPlayerFacade() {
        this.cdPlayer = new CdPlayer();
        this.mp3Player = new Mp3Player();
        this.streamingService = new StreamingService();
    }

    public void playCd() {
        cdPlayer.play();
    }

    public void pauseCd() {
        cdPlayer.pause();
    }

    public void stopCd() {
        cdPlayer.stop();
    }

    public void playMp3() {
        mp3Player.play();
    }

    public void pauseMp3() {
        mp3Player.pause();
    }

    public void stopMp3() {
        mp3Player.stop();
    }

    public void playStreamingMusic() {
        streamingService.play();
    }

    public void pauseStreamingMusic() {
        streamingService.pause();
    }

    public void stopStreamingMusic() {
        streamingService.stop();
    }
}
