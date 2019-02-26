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

            int idFeminineSoundRaceName = anActivity.getResources().getIdentifier(horse.getSoundFeminineRaceName(), "raw", anActivity.getPackageName());
            horse.setFeminineRaceSoundID(idFeminineSoundRaceName);
            int idMasculineSoundRaceName = anActivity.getResources().getIdentifier(horse.getSoundMasculineRaceName(), "raw", anActivity.getPackageName());
            horse.setMasculineRaceSoundID(idMasculineSoundRaceName);

            int idFeminineSoundFurName = anActivity.getResources().getIdentifier(horse.getSoundFeminineFurName(), "raw", anActivity.getPackageName());
            horse.setFeminineFurSoundID(idFeminineSoundFurName);
            int idMasculineSoundFurName = anActivity.getResources().getIdentifier(horse.getSoundMasculineFurName(), "raw", anActivity.getPackageName());
            horse.setMasculineFurSoundID(idMasculineSoundFurName);
        }
        return horses;
    }
}
