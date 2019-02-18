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
        ((ImageView) gameActivity.findViewById(R.id.wi_lo_horseImg)).setImageResource(correctAnswer.getImageResourceId());
    }

    public List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse) {
        throw new UnsupportedOperationException();
    }

    private Integer getRandomBetweenRaceAndFur(){
        // Se asume que 1 es Raza, y 2 es Pelaje
        return (Math.random() <= 0.5) ? 1 : 2;
    }

    public void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView){
        if(getRandomBetweenRaceAndFur() == 1){
            // ACA renderizaría la info del caballo. tengo que ver si la configuracion es hombre o mujer
        }else{
            // ACA renderizaría la info del caballo. tengo que ver si la configuracion es hombre o mujer

        }
    }

}