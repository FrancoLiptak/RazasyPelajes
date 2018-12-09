package com.francoliptak.razasypelajes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.utils.GameInitializer;
import com.francoliptak.razasypelajes.utils.Horse;
import com.francoliptak.razasypelajes.utils.SoundManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RazasYPelajes extends AppCompatActivity {
    private List<ImageView> horsesViews;
    private TextView raceName;
    private Horse correctAnswer;
    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.razas_y_pelajes);
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
        SoundManager.associateSounds(MediaPlayer.create(this, R.raw.horse_sound),
                                     MediaPlayer.create(this, R.raw.success_sound),
                                     MediaPlayer.create(this, R.raw.error_sound));
    }

    public List<ImageView> getHorsesViews() {
        return horsesViews;
    }

    public TextView getRaceName() {
        return raceName;
    }

    public int getAnswer() {
        return answer;
    }

    public void playHorseSound(View view){
        SoundManager.playHorse();
    }

    @Override
    public void onBackPressed(){
        correctAnswer = null;
        GameInitializer.destroy();
        finish();
    }
}
