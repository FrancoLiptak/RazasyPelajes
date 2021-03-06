package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameOneLevelOneWI extends LevelOneWI {

    public GameOneLevelOneWI(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<Integer> correctHorseSound, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer raceOrFur){
        if(raceOrFur == 1){
            textView.setText(aHorse.getRace());
            if(gameActivity.selectedSoundIsFemale()) {
                List<Integer> list = new ArrayList<>();
                list.add(aHorse.getFeminineRaceSoundID());
                imageView.setTag(list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(aHorse.getMasculineRaceSoundID());
                imageView.setTag(list);
            }
        }else{
            textView.setText(aHorse.getFur());
            if(gameActivity.selectedSoundIsFemale()) {
                List<Integer> list = new ArrayList<>();
                list.add(aHorse.getFeminineFurSoundID());
                imageView.setTag(list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(aHorse.getMasculineFurSoundID());
                imageView.setTag(list);
            }
        }
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, Integer raceOrFur){
        ((ImageView) gameActivity.findViewById(R.id.wi_lo_horseImg)).setImageResource(correctAnswer.getImageResourceId());
    }

    public void displayAnimation(GameActivity gameActivity, Game game){
        gameActivity.showMenuAndAnimation();
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatTheGameIsOver(gameActivity);
    }

}