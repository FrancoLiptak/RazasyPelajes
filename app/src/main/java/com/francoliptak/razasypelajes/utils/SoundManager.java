package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;

public class SoundManager {
    private static MediaPlayer successSound;
    private static MediaPlayer errorSound;

    public static void associateSounds(MediaPlayer success, MediaPlayer error){
        successSound = success;
        errorSound = error;
    }

    public static void playHorse(MediaPlayer horseSound){
        horseSound.start();
    }

    public static void playSucces(){
        successSound.start();
    }

    public static void playError(){
        errorSound.start();
    }
}
