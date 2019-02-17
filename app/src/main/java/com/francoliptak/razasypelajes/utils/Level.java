package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Level {
    private Game game;
    private List<Horse> horses;
    private Horse correctAnswer = null;
    private MediaPlayer correctHorseSound = null;
    private int attempts = 0;
    private int hits = 0;
    private Integer correctAnswerViewID;

    public Level(Game game, List<Horse> horses) {
        this.game = game;
        this.horses = horses;
    }

    public void playLevel(GameActivity gameActivity){
        gameActivity.setContentView(this.getLayoutForLevel());
        gameActivity.setActualLevelHandler(this);
        initializeRound(gameActivity);
    }

    public abstract int getLayoutForLevel();


    private void initializeRound(GameActivity gameActivity){
        destroy();
        printHorses(gameActivity);
    }

    public void printHorses(GameActivity gameActivity){
        List<Horse> horses = new ArrayList<>();
        horses.addAll(this.horses);
        List<ImageView> views = new ArrayList<>();
        views.addAll(this.getHorsesViews(gameActivity));
        Random r = new Random();
        for(int i = 0; i < this.getAmountOfTotalOptions(); i++) {
            Horse randomHorse = horses.get(r.nextInt(horses.size()));
            horses.remove(randomHorse);
            ImageView imageView = views.get(r.nextInt(views.size()));
            views.remove(imageView);
            if (correctAnswer == null) {
                correctAnswer = randomHorse;
                correctAnswerViewID = imageView.getId();
                if(gameActivity.selectedSoundIsFemale()){
                    correctHorseSound = randomHorse.getSoundFeminine();
                }else{
                    correctHorseSound = randomHorse.getSoundMasculine();
                }
            }
            int id = gameActivity.getResources().getIdentifier(randomHorse.getImageName(), "drawable", gameActivity.getPackageName());
            imageView.setImageResource(id);
        }
        this.showHorseInformationOnScreen(gameActivity, correctAnswer, correctHorseSound);
    }

    public void evaluateOptionChosen(View view, GameActivity gameActivity){
        attempts++;
        if(view.getId() == correctAnswerViewID){
            SoundManager.playSucces();
            hits++;
        }else{
            SoundManager.playError();
        }

        if(attempts < 5){
            initializeRound(gameActivity);
        }else{
            if(hits >= 3){
                // gameActivity.showConfetti();
                this.nextStep(gameActivity, game);
            }else{
                gameActivity.destroy();
            }
        }
    }

    private void destroy(){
        correctAnswer = null;
        correctHorseSound = null;
        correctAnswerViewID = null;
    }

    public abstract void nextStep(GameActivity gameActivity, Game game);

    public abstract void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, MediaPlayer correctHorseSound);

    public abstract List<ImageView> getHorsesViews(GameActivity gameActivity);

    public abstract int getAmountOfTotalOptions();
}
