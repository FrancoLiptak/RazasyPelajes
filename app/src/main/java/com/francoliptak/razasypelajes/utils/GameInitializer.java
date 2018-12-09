package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.widget.ImageView;

import com.francoliptak.razasypelajes.R;
import com.francoliptak.razasypelajes.RazasYPelajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameInitializer {
    private static List<Horse> horses = null;
    private static Horse correctAnswer = null;
    private static Integer correctAnswerView = null;
    private static MediaPlayer correctHorseSound = null;

    public static void initialize(RazasYPelajes razasYPelajes){
        destroy();
        createHorses(razasYPelajes);
        printHorses(razasYPelajes);
    }

    public static void createHorses(RazasYPelajes razasYPelajes){
        horses = new ArrayList<>();
        horses.add(new Horse("Raza1", "Pelaje1", razasYPelajes.getString(R.string.photoHorse1), MediaPlayer.create(razasYPelajes, R.raw.horse_sound_1)));
        horses.add(new Horse("Raza2", "Pelaje2", razasYPelajes.getString(R.string.photoHorse2), MediaPlayer.create(razasYPelajes, R.raw.horse_sound_2)));
        horses.add(new Horse("Raza3", "Pelaje3", razasYPelajes.getString(R.string.photoHorse3), MediaPlayer.create(razasYPelajes, R.raw.horse_sound_3)));
        horses.add(new Horse("Raza4", "Pelaje4", razasYPelajes.getString(R.string.photoHorse4), MediaPlayer.create(razasYPelajes, R.raw.horse_sound_4)));
    }

    public static void printHorses(RazasYPelajes razasYPelajes){
        Random r = new Random();
        while (horses.size() > 0){
            Horse randomHorse = horses.get(r.nextInt(horses.size()));
            horses.remove(randomHorse);
            List<ImageView> views = razasYPelajes.getHorsesViews();
            ImageView imageView = views.get(r.nextInt(views.size()));
            views.remove(imageView);
            if(correctAnswer == null){
                correctAnswerView = imageView.getId();
                correctAnswer = randomHorse;
                correctHorseSound = randomHorse.getSoundName();
            }
            int id = razasYPelajes.getResources().getIdentifier(randomHorse.getImageName(), "drawable", razasYPelajes.getPackageName());
            imageView.setImageResource(id);
        }
        razasYPelajes.getRaceName().setText(correctAnswer.getRace());
        razasYPelajes.setHorseSound(correctHorseSound);
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
