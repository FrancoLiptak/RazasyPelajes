package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.List;

public class GameOneLevelOneWI extends LevelOneWI {

    public GameOneLevelOneWI(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound) {
        throw new UnsupportedOperationException();
    }

    public List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse) {
        throw new UnsupportedOperationException();
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer randomBetweenRaceAndFur){
        if(randomBetweenRaceAndFur == 1){
            textView.setText(aHorse.getRace());
            // ACA renderizaría la info del caballo. tengo que ver si la configuracion es hombre o mujer para el nombre de raza o pelaje
        }else{
            // ACA renderizaría la info del caballo. tengo que ver si la configuracion es hombre o mujer para el nombre de raza o pelaje
            textView.setText(aHorse.getFur());
        }
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer){
        ((ImageView) gameActivity.findViewById(R.id.wi_lo_horseImg)).setImageResource(correctAnswer.getImageResourceId());
    }

}