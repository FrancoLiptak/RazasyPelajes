package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.List;

public class GameTwoLevelTwoIW extends LevelTwoIW {

    public GameTwoLevelTwoIW(Game game, List<Horse> horses) {
        super(game, horses);
    }

    public void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, MediaPlayer correctHorseSound){
        ((TextView) gameActivity.findViewById(R.id.iw_lt_horseName)).setText(correctAnswer.getRace() + " - " + correctAnswer.getFur());
        gameActivity.setHorseRaceOrFurNameSound(correctHorseSound); // Tengo que poder reproducir dos audios
    }
}
