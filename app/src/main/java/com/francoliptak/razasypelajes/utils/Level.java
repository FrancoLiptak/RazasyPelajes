package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class Level {
    private Game game;
    private List<Horse> horses;
    private Horse correctAnswer = null;
    private int attempts = 0;
    private int hits = 0;
    private Integer correctAnswerViewID;
    private NameOfInteractions nameOfInteraction;
    private List<Horse> options;

    public Level(Game game, List<Horse> horses, NameOfInteractions nameOfInteraction) {
        this.game = game;
        this.horses = horses;
        this.nameOfInteraction = nameOfInteraction;
    }

    public void playLevel(GameActivity gameActivity){
        gameActivity.setContentView(this.getLayoutForLevel());
        gameActivity.setActualLevelHandler(this);
        initializeRound(gameActivity);
    }

    public abstract int getLayoutForLevel();


    private void initializeRound(GameActivity gameActivity){
        destroy();
        if(this.nameOfInteraction == NameOfInteractions.IMG_WORD){
            printHorsesForIW(gameActivity);
        }else{
            printHorsesForWI(gameActivity);
        }
    }

    public void printHorsesForIW(GameActivity gameActivity){
        options = new ArrayList<>();
        List<MediaPlayer> correctHorseSounds = null;
        List<Horse> horses = new ArrayList<>();
        horses.addAll(this.horses);
        List<ImageView> views = new ArrayList<>();
        views.addAll(this.getHorsesImgViews(gameActivity));
        Random r = new Random();
        int raceOrFur = getRandomBetweenRaceAndFur();
        for(int i = 0; i < this.getAmountOfTotalOptions(); i++) {
            Horse randomHorse = getHorse(horses, r);
            ImageView imageView = views.get(r.nextInt(views.size()));
            views.remove(imageView);
            if (correctAnswer == null) {
                correctAnswer = randomHorse;
                correctAnswerViewID = imageView.getId();
                correctHorseSounds = this.saveHorsesNamesAndFurSounds(gameActivity, randomHorse, raceOrFur);
            }
            int id = gameActivity.getResources().getIdentifier(randomHorse.getImageName(), "drawable", gameActivity.getPackageName());
            imageView.setImageResource(id);
        }
        this.showHorseInformationOnScreen(gameActivity, correctAnswer, correctHorseSounds, raceOrFur);
    }

    public Horse getHorse(List<Horse> horses, Random r){
        boolean horseIsDiferent = false;
        Horse randomHorse = horses.get(r.nextInt(horses.size()));
        while(!horseIsDiferent){
            horses.remove(randomHorse);
            if((options.size() == 0) || (!containsFur(options, randomHorse.getFur()) && !containsRace(options, randomHorse.getRace()))){
                options.add(randomHorse);
                horseIsDiferent = true;
            }else{
                randomHorse = horses.get(r.nextInt(horses.size()));
            }
        }
        return randomHorse;
    }

    private boolean containsFur(List<Horse> options, String fur){
        for(Horse horse : options){
            if(horse.getFur().equals(fur)){
                return true;
            }
        }
        return false;
    }

    private boolean containsRace(List<Horse> options, String race){
        for(Horse horse : options){
            if(horse.getRace().equals(race)){
                return true;
            }
        }
        return false;
    }

    public void printHorsesForWI(GameActivity gameActivity){
        options = new ArrayList<>();
        List<Horse> horses = new ArrayList<>();
        horses.addAll(this.horses);
        List<TextView> textViews = new ArrayList<>();
        textViews.addAll(this.getHorsesTxtViews(gameActivity));
        List<ImageView> imageViews = new ArrayList<>();
        imageViews.addAll(this.getHorseSoundImageViews(gameActivity));
        Random r = new Random();
        int raceOrFur = getRandomBetweenRaceAndFur();
        for(int i = 0; i < this.getAmountOfTotalOptions(); i++) {
            Horse randomHorse = getHorse(horses, r);
            int nextInt = r.nextInt(textViews.size());
            TextView textView = textViews.get(nextInt);
            textViews.remove(textView);
            ImageView imageView = imageViews.get(nextInt);
            imageViews.remove(imageView);
            if (correctAnswer == null) {
                correctAnswer = randomHorse;
                correctAnswerViewID = textView.getId();
            }
            this.renderOption(gameActivity, randomHorse, textView, imageView, raceOrFur);
        }
        this.showHorseInformationOnScreen(gameActivity, correctAnswer, raceOrFur);
    }

    private Integer getRandomBetweenRaceAndFur(){
        // Se asume que 1 es Raza, y 2 es Pelaje
        return (Math.random() <= 0.5) ? 1 : 2;
    }

    public abstract void renderOption(GameActivity gameActivity, Horse aHorse, TextView textView, ImageView imageView, Integer randomBetweenRaceAndFur);

    public abstract List<MediaPlayer> saveHorsesNamesAndFurSounds(GameActivity gameActivity, Horse horse, Integer raceOrFur);

    public void evaluateOptionChosen(View view, GameActivity gameActivity){
        attempts++;
        if(view.getId() == correctAnswerViewID){
            SoundManager.playSucces();
            hits++;
        }else{
            SoundManager.playError();
        }

        if(attempts < 5){
            delay(2);
            initializeRound(gameActivity);
        }else{
            if(hits >= 3){
                this.displayAnimation(gameActivity, game);
            }else{
                gameActivity.destroy();
            }
        }
    }

    private void delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    private void destroy(){
        correctAnswer = null;
        correctAnswerViewID = null;
    }

    public abstract void displayAnimation(GameActivity gameActivity, Game game);

    public abstract void nextStep(GameActivity gameActivity, Game game);

    public abstract void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, List<MediaPlayer> correctHorseSounds, Integer raceOrFur);

    public abstract void showHorseInformationOnScreen(GameActivity gameActivity, Horse correctAnswer, Integer raceOrFur);

    public abstract List<ImageView> getHorsesImgViews(GameActivity gameActivity); // creo que algunos no la implementan

    public abstract List<TextView> getHorsesTxtViews(GameActivity gameActivity); // algunos no la implementan

    public abstract List<ImageView> getHorseSoundImageViews(GameActivity gameActivity); // algunos no la implementan

    public abstract int getAmountOfTotalOptions();
}
