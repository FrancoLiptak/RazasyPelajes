package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public abstract class LevelTwoWI extends Level {

    public LevelTwoWI(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        super(game, horses, nameOfInteraction);
    }

    public int getLayoutForLevel(){
        return R.layout.activity_game_wi_level_two;
    }

    public int getAmountOfTotalOptions(){
        return 4;
    }

    public abstract void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSound);

    public List<TextView> getHorsesTxtViews(GameActivity gameActivity) {
        List<TextView> horsesViews = new ArrayList<>();
        horsesViews.add((TextView) gameActivity.findViewById(R.id.wi_lt_optionOne));
        horsesViews.add((TextView) gameActivity.findViewById(R.id.wi_lt_optionTwo));
        horsesViews.add((TextView) gameActivity.findViewById(R.id.wi_lt_optionThree));
        horsesViews.add((TextView) gameActivity.findViewById(R.id.wi_lt_optionFour));
        return horsesViews;
    }

    public List<ImageView> getHorseSoundImageViews(GameActivity gameActivity){
        List<ImageView> horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.wi_lt_soundOne));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.wi_lt_soundTwo));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.wi_lt_soundThree));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.wi_lt_soundFour));
        return horsesViews;
    }

    public List<ImageView> getHorsesImgViews(GameActivity gameActivity){
        throw new UnsupportedOperationException();
    }

    public abstract void nextStep(GameActivity gameActivity, Game game);

    public abstract List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse);
}
