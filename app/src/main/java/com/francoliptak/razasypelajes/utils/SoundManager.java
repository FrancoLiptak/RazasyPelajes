package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;

public class SoundManager {
    private static MediaPlayer horseSound;
    private static MediaPlayer successSound;
    private static MediaPlayer errorSound;

    public static void associateSounds(MediaPlayer horse, MediaPlayer success, MediaPlayer error){
        horseSound = horse;
        successSound = success;
        errorSound = error;
    }

    public static void playHorse(){
        horseSound.start();
    }

    public static void playSucces(){
        successSound.start();
    }

    public static void playError(){
        errorSound.start();
    }
}
