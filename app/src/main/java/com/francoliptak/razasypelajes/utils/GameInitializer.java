package com.francoliptak.razasypelajes.utils;

import android.widget.ImageView;

import com.francoliptak.razasypelajes.R;
import com.francoliptak.razasypelajes.RazasYPelajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameInitializer {
    private static List<Horse> horses = null;
    private static Horse correctAnswer = null;

    public static void initialize(RazasYPelajes razasYPelajes){
        createHorses(razasYPelajes);
        printHorses(razasYPelajes);
    }

    public static void createHorses(RazasYPelajes razasYPelajes){
        horses = new ArrayList<>();
        horses.add(new Horse("Raza1", "Pelaje1", razasYPelajes.getString(R.string.photoHorse1)));
        horses.add(new Horse("Raza2", "Pelaje2", razasYPelajes.getString(R.string.photoHorse2)));
        horses.add(new Horse("Raza3", "Pelaje3", razasYPelajes.getString(R.string.photoHorse3)));
        horses.add(new Horse("Raza4", "Pelaje4", razasYPelajes.getString(R.string.photoHorse4)));
    }

    public static void printHorses(RazasYPelajes razasYPelajes){
        Random r = new Random();
        while (horses.size() > 0){
            Horse randomHorse = horses.get(r.nextInt(horses.size()));
            horses.remove(randomHorse);
            if(correctAnswer == null){ correctAnswer = randomHorse;}
            List<ImageView> views = razasYPelajes.getHorsesViews();
            ImageView imageView = views.get(r.nextInt(views.size()));
            views.remove(imageView);
            int id = razasYPelajes.getResources().getIdentifier(randomHorse.getImage(), "drawable", razasYPelajes.getPackageName());
            imageView.setImageResource(id);
        }
        razasYPelajes.getRaceName().setText(correctAnswer.getRace());
    }

    public static Horse getCorrectAnswer(){
        return correctAnswer;
    }

    public static void destroy(){
        horses = null;
        correctAnswer = null;
    }
}
