package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class GameTwoLevelTwoIW extends LevelTwoIW {

    public GameTwoLevelTwoIW(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound){
        ((TextView) gameActivity.findViewById(R.id.iw_lt_horseName)).setText(correctAnswer.getRace() + " - " + correctAnswer.getFur());
        gameActivity.setHorseRaceOrFurNameSounds(correctHorseSound);
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

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatAllGamesWereFinished(gameActivity);
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView){
        throw new UnsupportedOperationException();
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer){
        throw new UnsupportedOperationException();
    }
}
