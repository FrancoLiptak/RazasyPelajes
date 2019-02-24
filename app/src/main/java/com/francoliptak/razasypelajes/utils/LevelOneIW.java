package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public abstract class LevelOneIW extends Level {

    public LevelOneIW(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public int getLayoutForLevel(){
        return R.layout.activity_game_iw_level_one;
    }

    public int getAmountOfTotalOptions(){
        return 2;
    }

    public List<ImageView> getHorsesImgViews(GameActivity gameActivity) {
        List<ImageView> horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.iw_lo_optionOne));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.iw_lo_optionTwo));
        return horsesViews;
    }

    public List<TextView> getHorsesTxtViews(GameActivity gameActivity) {
        throw new UnsupportedOperationException();
    }

    public List<ImageView> getHorseSoundImageViews(GameActivity gameActivity){
        throw new UnsupportedOperationException();
    }

    public abstract void nextStep(GameActivity gameActivity, Game game);

}
