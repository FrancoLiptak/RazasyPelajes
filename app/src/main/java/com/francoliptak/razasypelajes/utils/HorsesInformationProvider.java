package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class HorsesInformationProvider {

    public static List<Horse> getHorses(AppCompatActivity anActivity) {
        List<Horse> horses = AcquirerOfJSONFiles.getHorses(anActivity, new ObjectMapper());
        return getHorsesWithSounds(horses, anActivity);
    }

    public static List<Horse> getHorsesWithSounds(List<Horse> horses, AppCompatActivity anActivity) {
        for(Horse horse : horses) {
            int idFeminineSound = anActivity.getResources().getIdentifier(horse.getSoundFeminineName(), "raw", anActivity.getPackageName());
            horse.setSoundFeminine(MediaPlayer.create(anActivity, idFeminineSound));
            int idMasculineSound = anActivity.getResources().getIdentifier(horse.getSoundMasculineName(), "raw", anActivity.getPackageName());
            horse.setSoundMasculine(MediaPlayer.create(anActivity, idMasculineSound));
        }
        return horses;
    }
}
