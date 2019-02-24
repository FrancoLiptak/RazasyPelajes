package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.List;

public class GameOneLevelTwoWI extends LevelTwoWI {

    public GameOneLevelTwoWI(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer raceOrFur){
        if(raceOrFur == 1){
            textView.setText(aHorse.getRace());
            if(gameActivity.selectedSoundIsFemale()) {
                imageView.setTag(aHorse.getSoundFeminineRace());
            }else{
                imageView.setTag(aHorse.getSoundMasculineRace());
            }
        }else{
            textView.setText(aHorse.getFur());
            if(gameActivity.selectedSoundIsFemale()) {
                imageView.setTag(aHorse.getSoundFeminineFur());
            }else{
                imageView.setTag(aHorse.getSoundMasculineFur());
            }
        }
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, Integer raceOrFur){
        ((ImageView) gameActivity.findViewById(R.id.wi_lt_horseImg)).setImageResource(correctAnswer.getImageResourceId());
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatTheGameIsOver(gameActivity);
    }

    public void displayAnimation(GameActivity gameActivity, Game game){
        gameActivity.showMenuAndAnimation();
    }
}