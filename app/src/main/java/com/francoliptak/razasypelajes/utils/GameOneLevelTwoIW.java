package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameOneLevelTwoIW extends LevelTwoIW {

    public GameOneLevelTwoIW(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound, Integer raceOrFur){
        if(raceOrFur == 1){
            ((TextView) gameActivity.findViewById(R.id.iw_lt_horseName)).setText(correctAnswer.getRace());
            gameActivity.setHorseRaceOrFurNameSounds(correctHorseSound);
        }else{
            ((TextView) gameActivity.findViewById(R.id.iw_lt_horseName)).setText(correctAnswer.getFur());
            gameActivity.setHorseRaceOrFurNameSounds(correctHorseSound);
        }
    }

    public List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse, Integer raceOrFur){
        List<MediaPlayer> sounds = new ArrayList<>();
        if(gameActivity.selectedSoundIsFemale()){
            if(raceOrFur == 1){
                sounds.add(horse.getSoundFeminineRace());
            }else{
                sounds.add(horse.getSoundFeminineFur());
            }
        }else{
            if(raceOrFur == 1){
                sounds.add(horse.getSoundMasculineRace());
            }else{
                sounds.add(horse.getSoundMasculineFur());
            }
        }
        return sounds;
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer randomBetweenRaceAndFur){
        throw new UnsupportedOperationException();
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, Integer raceOrFur){
        throw new UnsupportedOperationException();
    }

    public void displayAnimation(GameActivity gameActivity, Game game){
        gameActivity.showMenuAndAnimation();
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatTheGameIsOver(gameActivity);
    }

}
