package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public abstract class LevelTwoIW extends Level {

    public LevelTwoIW(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public int getLayoutForLevel(){
        return R.layout.activity_game_iw_level_two;
    }

    public int getAmountOfTotalOptions(){
        return 4;
    }

    public List<ImageView> getHorsesImgViews(GameActivity gameActivity) {
        List<ImageView> horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionOne));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionTwo));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionThree));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lt_optionFour));
        return horsesViews;
    }

    public List<TextView> getHorsesTxtViews(GameActivity gameActivity) {
        throw new UnsupportedOperationException();
    }

    public List<ImageView> getHorseSoundImageViews(GameActivity gameActivity){
        throw new UnsupportedOperationException();
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.informThatAllGamesWereFinished(gameActivity);
    }

}
