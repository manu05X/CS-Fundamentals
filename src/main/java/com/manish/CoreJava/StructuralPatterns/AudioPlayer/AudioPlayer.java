package com.manish.CoreJava.StructuralPatterns.AudioPlayer;


class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    AudioPlayer() {
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (!audioType.equalsIgnoreCase("vlc") && !audioType.equalsIgnoreCase("mp4")) {
            System.out.println("Invalid media. " + audioType + " format not supported");
        } else {
            this.mediaAdapter = new MediaAdapter(audioType);
            this.mediaAdapter.play(audioType, fileName);
        }

    }
}