package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class HorsesInformationProvider {

    public static List<Horse> getHorses(AppCompatActivity anActivity) {
        List<Horse> horses = ReaderOfJSONFiles.getHorses(anActivity, new ObjectMapper());
        return getHorsesWithSounds(horses, anActivity);
    }

    public static List<Horse> getHorsesWithSounds(List<Horse> horses, AppCompatActivity anActivity) {
        for(Horse horse : horses) {
            int resourceImageID = anActivity.getResources().getIdentifier(horse.getImageName(), "drawable", anActivity.getPackageName());
            horse.setImageResourceId(resourceImageID);
            int idFeminineSound = anActivity.getResources().getIdentifier(horse.getSoundFeminineRaceName(), "raw", anActivity.getPackageName());
            horse.setFeminineRaceSoundID(idFeminineSound);
            horse.setSoundFeminine(MediaPlayer.create(anActivity, idFeminineSound));
            int idMasculineSound = anActivity.getResources().getIdentifier(horse.getSoundMasculineRaceName(), "raw", anActivity.getPackageName());
            horse.setMasculineRaceSoundID(idMasculineSound);
            horse.setSoundMasculine(MediaPlayer.create(anActivity, idMasculineSound));
        }
        return horses;
    }
}
