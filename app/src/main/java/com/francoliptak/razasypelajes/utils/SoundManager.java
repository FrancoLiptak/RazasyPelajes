package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void playSounds(List<MediaPlayer> soundTags){
        if(soundTags.size() > 1){
            for(int i = 0; i < soundTags.size() - 1; i++){
                soundTags.get(i).setNextMediaPlayer(soundTags.get(i+1));
            }
        }
        soundTags.get(0).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void playSounds(List<Integer> soundTags, AppCompatActivity anActivity){
        List<MediaPlayer> mediaPlayers = createMediaPlayers(soundTags, anActivity);
        if(mediaPlayers.size() > 1){
            for(int i = 0; i < mediaPlayers.size() - 1; i++){
                mediaPlayers.get(i).setNextMediaPlayer(mediaPlayers.get(i+1));
            }
        }
        mediaPlayers.get(0).start();
    }

    private static List<MediaPlayer> createMediaPlayers(List<Integer> soundTags, AppCompatActivity activity){
        List<MediaPlayer> mediaPlayers = new ArrayList<>();
        for(Integer integer : soundTags){
            mediaPlayers.add(MediaPlayer.create(activity, integer));
        }
        return mediaPlayers;
    }
}
