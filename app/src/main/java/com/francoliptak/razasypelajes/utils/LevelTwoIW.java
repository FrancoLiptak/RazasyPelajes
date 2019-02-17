package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public abstract class LevelTwoIW extends Level {

    public LevelTwoIW(Game game, List<Horse> horses) {
        super(game, horses);
    }

    public int getLayoutForLevel(){
        return R.layout.activity_game_iw_level_two;
    }

    public int getAmountOfTotalOptions(){
        return 4;
    }

    public abstract void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, MediaPlayer correctHorseSound);

    public List<ImageView> getHorsesViews(GameActivity gameActivity) {
        List<ImageView> horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionOne));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionTwo));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionThree));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionFour));
        return horsesViews;
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatTheGameIsOver(gameActivity);
    }
}
