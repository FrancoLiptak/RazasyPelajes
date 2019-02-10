package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

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

    public static void playSounds(AppCompatActivity anActivity, List<MediaPlayer> soundTags){
        for(MediaPlayer soundTag : soundTags){
            soundTag.start();
        }
    }
}
