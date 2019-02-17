package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameTwoLevelOneIW extends LevelOneIW {

    public GameTwoLevelOneIW(Game game, List<Horse> horses) {
        super(game, horses);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseRaceOrFurNameSounds){
        ((TextView) gameActivity.findViewById(R.id.iw_lo_horseName)).setText(correctAnswer.getRace() + " - " + correctAnswer.getFur());
        gameActivity.setHorseRaceOrFurNameSounds(correctHorseRaceOrFurNameSounds); // Tengo que poder reproducir dos audios
    }

    public List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse){
        List<MediaPlayer> sounds = new ArrayList<>();
        if(gameActivity.selectedSoundIsFemale()){
            sounds.add(horse.getSoundFeminine());
            sounds.add(horse.getSoundMasculine());
        }else{
            sounds.add(horse.getSoundMasculine());
            sounds.add(horse.getSoundFeminine());
        }
        return sounds;
    }
}
