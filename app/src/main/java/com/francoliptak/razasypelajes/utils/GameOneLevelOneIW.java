package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

import com.francoliptak.razasypelajes.GameActivity;
import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameOneLevelOneIW extends Level{
    private Game game;
    private List<ImageView> horsesViews;
    private List<Horse> horses;
    private Horse correctAnswer = null;
    private MediaPlayer correctHorseSound = null;
    private int attempts;
    private int hits;
    private Integer correctAnswerViewID;

    public GameOneLevelOneIW(List<Horse> horses, Game game) {
        this.horses = horses;
        this.game = game;
    }

    public void playLevel(GameActivity gameActivity){
        gameActivity.setContentView(R.layout.activity_game_iw_level_one);
        gameActivity.setActualLevelHandler(this);
        attempts = 0;
        hits = 0;
        initializeRound(gameActivity);
    }

    private void initializeRound(GameActivity gameActivity){
        destroy();
        printHorses(gameActivity, this.getRandomBetweenRaceAndFur());
    }

    public void printHorses(GameActivity gameActivity, Integer randomBetweenRaceAndFur){
        Random r = new Random();
        for(int i = 0; i < 2; i++) {
            Horse randomHorse = horses.get(r.nextInt(horses.size()));
            horses.remove(randomHorse);
            List<ImageView> views = this.getHorsesViews(gameActivity);
            ImageView imageView = horsesViews.get(r.nextInt(views.size()));
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
        if(randomBetweenRaceAndFur == 1){
            gameActivity.getRaceOrFurNameTextView().setText(correctAnswer.getRace());
            gameActivity.setHorseRaceOrFurNameSound(correctHorseSound);
        }else{
            gameActivity.getRaceOrFurNameTextView().setText(correctAnswer.getFur());
            gameActivity.setHorseRaceOrFurNameSound(correctHorseSound);
        }
    }

    private void destroy(){
        correctAnswer = null;
        correctHorseSound = null;
        correctAnswerViewID = null;
    }

    private Integer getRandomBetweenRaceAndFur(){
        // Se asume que 1 es Raza, y 2 es Pelaje
        return (Math.random() <= 0.5) ? 1 : 2;
    }

    private List<ImageView> getHorsesViews(GameActivity gameActivity) {
        horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lo_optionOne));
        horsesViews.add((ImageView) gameActivity.findViewById(R.id.ip_lo_optionTwo));
        return horsesViews;
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
                game.playLevelTwo(gameActivity);
            }else{
                gameActivity.destroy();
            }
        }
    }

}
