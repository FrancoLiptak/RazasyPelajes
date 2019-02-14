package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;

import com.francoliptak.razasypelajes.R;
import com.francoliptak.razasypelajes.GameActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameInitializer {
    private static List<Horse> horses = null;
    private static Horse correctAnswer = null;
    private static Integer correctAnswerView = null;
    private static MediaPlayer correctHorseSound = null;

    public static void initialize(GameActivity gameActivity){
        destroy();
        horses = HorsesInformationProvider.getHorses(gameActivity);
        printHorses(gameActivity);
    }

    public static void printHorses(GameActivity gameActivity){
        Random r = new Random();
        while (horses.size() > 3){
            Horse randomHorse = horses.get(r.nextInt(horses.size()));
            horses.remove(randomHorse);
            List<ImageView> views = gameActivity.getHorsesViews();
            ImageView imageView = views.get(r.nextInt(views.size()));
            views.remove(imageView);
            if(correctAnswer == null){
                correctAnswerView = imageView.getId();
                correctAnswer = randomHorse;
                correctHorseSound = randomHorse.getSoundMasculine();
            }
            int id = gameActivity.getResources().getIdentifier(randomHorse.getImageName(), "drawable", gameActivity.getPackageName());
            imageView.setImageResource(id);
        }
        gameActivity.getRaceName().setText(correctAnswer.getRace());
        gameActivity.setHorseSound(correctHorseSound);
    }

    public static Integer getCorrectAnswer(){
        return correctAnswerView;
    }

    public static void destroy(){
        horses = null;
        correctAnswer = null;
        correctAnswerView = null;
        correctHorseSound = null;
    }
}
