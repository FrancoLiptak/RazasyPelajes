package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameTwoLevelOneWI extends LevelOneWI {

    public GameTwoLevelOneWI(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse, Integer raceOrFur) {
        throw new UnsupportedOperationException();
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer raceOrFur){
        textView.setText(aHorse.getRace() + " - " + aHorse.getFur());
        if(gameActivity.selectedSoundIsFemale()) {
            List<MediaPlayer> sounds = new ArrayList<>();
            sounds.add(aHorse.getSoundFeminineRace());
            sounds.add(aHorse.getSoundFeminineFur());
            imageView.setTag(sounds);
        }else{
            List<MediaPlayer> sounds = new ArrayList<>();
            sounds.add(aHorse.getSoundMasculineRace());
            sounds.add(aHorse.getSoundMasculineFur());
            imageView.setTag(sounds);
        }
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, Integer raceOrFur){
        ((ImageView) gameActivity.findViewById(R.id.wi_lo_horseImg)).setImageResource(correctAnswer.getImageResourceId());
    }

    public void displayAnimation(GameActivity gameActivity, Game game){
        gameActivity.showMenuAndAnimation();
    }

}
