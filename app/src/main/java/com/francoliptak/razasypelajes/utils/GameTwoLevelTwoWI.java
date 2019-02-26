package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameTwoLevelTwoWI extends LevelTwoWI {

    public GameTwoLevelTwoWI(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<Integer> correctHorseSound, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer randomBetweenRaceAndFur){
        textView.setText(aHorse.getRace() + " - " + aHorse.getFur());
        if(gameActivity.selectedSoundIsFemale()) {
            List<Integer> sounds = new ArrayList<>();
            sounds.add(aHorse.getFeminineRaceSoundID());
            sounds.add(aHorse.getFeminineFurSoundID());
            imageView.setTag(sounds);
        }else{
            List<Integer> sounds = new ArrayList<>();
            sounds.add(aHorse.getMasculineRaceSoundID());
            sounds.add(aHorse.getMasculineFurSoundID());
            imageView.setTag(sounds);
        }
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, Integer raceOrFur){
        ((ImageView) gameActivity.findViewById(R.id.wi_lt_horseImg)).setImageResource(correctAnswer.getImageResourceId());
    }

    public void displayAnimation(GameActivity gameActivity, Game game){
        gameActivity.showFinalMenuAndAnimation();
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatAllGamesWereFinished(gameActivity);
    }

}