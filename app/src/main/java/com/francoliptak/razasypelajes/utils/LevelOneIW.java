package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public abstract class LevelOneIW extends Level {

    public LevelOneIW(Game game, List<Horse> horses) {
        super(game, horses);
    }

    public int getLayoutForLevel(){
        return R.layout.activity_game_iw_level_one;
    }

    public int getAmountOfTotalOptions(){
        return 2;
    }

    public abstract void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound);

    public List<ImageView> getHorsesViews(GameActivity gameActivity) {
        List<ImageView> horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lo_optionOne));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lo_optionTwo));
        return horsesViews;
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.playLevelTwo(gameActivity);
    }

    public abstract List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse);

}
