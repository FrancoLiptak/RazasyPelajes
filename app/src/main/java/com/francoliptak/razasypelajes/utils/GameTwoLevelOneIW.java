package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameTwoLevelOneIW extends LevelOneIW {

    public GameTwoLevelOneIW(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<Integer> correctHorseRaceOrFurNameSounds, Integer raceOrFur){
        ((TextView) gameActivity.findViewById(R.id.iw_lo_horseName)).setText(correctAnswer.getRace() + " - " + correctAnswer.getFur());
        gameActivity.setHorseRaceOrFurNameSounds(correctHorseRaceOrFurNameSounds);
    }

    public List<Integer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse, Integer raceOrFur){
        List<Integer> sounds = new ArrayList<>();
        if(gameActivity.selectedSoundIsFemale()){
            sounds.add(horse.getFeminineRaceSoundID());
            sounds.add(horse.getFeminineFurSoundID());
        }else{
            sounds.add(horse.getMasculineRaceSoundID());
            sounds.add(horse.getMasculineFurSoundID());
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
        gameActivity.showFinalMenuAndAnimation();
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatAllGamesWereFinished(gameActivity);
    }
}
