package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.List;

public class GameOneLevelOneIW extends LevelOneIW{

    public GameOneLevelOneIW(Game game, List<Horse> horses) {
        super(game, horses);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, MediaPlayer correctHorseSound){
        if(getRandomBetweenRaceAndFur() == 1){
            ((TextView) gameActivity.findViewById(R.id.iw_lo_horseName)).setText(correctAnswer.getRace());
            gameActivity.setHorseRaceOrFurNameSound(correctHorseSound);
        }else{
            ((TextView) gameActivity.findViewById(R.id.iw_lo_horseName)).setText(correctAnswer.getFur());
            gameActivity.setHorseRaceOrFurNameSound(correctHorseSound);
        }
    }

    private Integer getRandomBetweenRaceAndFur(){
        // Se asume que 1 es Raza, y 2 es Pelaje
        return (Math.random() <= 0.5) ? 1 : 2;
    }

}
