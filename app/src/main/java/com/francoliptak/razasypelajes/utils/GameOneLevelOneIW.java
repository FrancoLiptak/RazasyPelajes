package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameOneLevelOneIW extends LevelOneIW{

    public GameOneLevelOneIW(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound){
        if(getRandomBetweenRaceAndFur() == 1){
            ((TextView) gameActivity.findViewById(R.id.iw_lo_horseName)).setText(correctAnswer.getRace());
            gameActivity.setHorseRaceOrFurNameSounds(correctHorseSound);
        }else{
            ((TextView) gameActivity.findViewById(R.id.iw_lo_horseName)).setText(correctAnswer.getFur());
            gameActivity.setHorseRaceOrFurNameSounds(correctHorseSound);
        }
    }

    private Integer getRandomBetweenRaceAndFur(){
        // Se asume que 1 es Raza, y 2 es Pelaje
        return (Math.random() <= 0.5) ? 1 : 2;
    }

    public List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse){
        List<MediaPlayer> sounds = new ArrayList<>();
        if(gameActivity.selectedSoundIsFemale()){
            sounds.add(horse.getSoundFeminine());
        }else{
            sounds.add(horse.getSoundMasculine());
        }
        return sounds;
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer randomBetweenRaceAndFur){
        throw new UnsupportedOperationException();
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer){
        throw new UnsupportedOperationException();
    }

    public void displayAnimation(GameActivity gameActivity, Game game){
        gameActivity.showMenuAndAnimation();
    }

}
