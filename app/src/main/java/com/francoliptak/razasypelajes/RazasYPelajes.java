package com.francoliptak.razasypelajes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.utils.GameInitializer;
import com.francoliptak.razasypelajes.utils.SoundManager;

import java.util.ArrayList;
import java.util.List;

public class RazasYPelajes extends AppCompatActivity {
    private List<ImageView> horsesViews;
    private TextView raceName; // Nombre de la raza del caballo a adivinar
    private MediaPlayer horseSound; // Nombre del archivo de sonido del caballo a adivinar
    private Integer correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_interaccion_ip);
        associateElementsToVariables();
        GameInitializer.initialize(this);
        correctAnswer = GameInitializer.getCorrectAnswer();
    }

    private void associateElementsToVariables(){
        associateHorsesViewsToVariables();
        associateSounds();
        raceName = findViewById(R.id.raceText);
    }

    private void associateHorsesViewsToVariables(){
        horsesViews = new ArrayList<>();
        horsesViews.add((ImageView) findViewById(R.id.imageView1));
        horsesViews.add((ImageView) findViewById(R.id.imageView2));
        horsesViews.add((ImageView) findViewById(R.id.imageView3));
        horsesViews.add((ImageView) findViewById(R.id.imageView4));
    }

    private void associateSounds(){
        SoundManager.associateSounds(MediaPlayer.create(this, R.raw.success_sound),
                                     MediaPlayer.create(this, R.raw.error_sound));
    }

    public List<ImageView> getHorsesViews() {
        return horsesViews;
    }

    public TextView getRaceName() {
        return raceName;
    }

    public void playHorseSound(View view){
        SoundManager.playHorse(horseSound);
    }

    public void evaluateOptionChosen(View view){
        if(view.getId() == correctAnswer){
            SoundManager.playSucces();
            finish();
        }else{
            SoundManager.playError();
        }
    }

    public void setHorseSound(MediaPlayer horseSound) {
        this.horseSound = horseSound;
    }

    public void goBack(View view){
        goBack();
    }

    private void goBack(){
        correctAnswer = null;
        horseSound = null;
        GameInitializer.destroy();
        finish();
    }

    @Override
    public void onBackPressed(){
        goBack();
    }
}
