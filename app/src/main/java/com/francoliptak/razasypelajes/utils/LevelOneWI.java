package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public abstract class LevelOneWI extends Level {

    public LevelOneWI(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public int getLayoutForLevel(){
        return R.layout.activity_game_wi_level_one;
    }

    public int getAmountOfTotalOptions(){
        return 2;
    }

    public abstract void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound);

    public List<TextView> getHorsesTxtViews(GameActivity gameActivity) {
        List<TextView> horsesViews = new ArrayList<>();
        horsesViews.add((TextView) gameActivity.findViewById(R.id.wi_lo_optionOne));
        horsesViews.add((TextView) gameActivity.findViewById(R.id.wi_lo_optionTwo));
        return horsesViews;
    }

    public List<ImageView> getHorseSoundImageViews(GameActivity gameActivity){
        List<ImageView> horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.wi_lo_soundOne));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.wi_lo_soundTwo));
        return horsesViews;
    }

    public List<ImageView> getHorsesImgViews(GameActivity gameActivity){
        throw new UnsupportedOperationException();
    }

    public void nextStep(GameActivity gameActivity, Game game){
        game.playLevelTwo(gameActivity);
    }

    public abstract List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse);

    public abstract void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView);

}
