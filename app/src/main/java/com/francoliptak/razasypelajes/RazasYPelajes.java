package com.francoliptak.razasypelajes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RazasYPelajes extends AppCompatActivity {
    private List<ImageView> horsesViews;
    private Map<String, MediaPlayer> sounds;
    private TextView raceName;
    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.razas_y_pelajes);
        associateElementsToVariables();
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
        sounds = new HashMap<>();
        sounds.put(getString(R.string.horse_sound), MediaPlayer.create(this, R.raw.horse_sound));
        sounds.put(getString(R.string.error_sound), MediaPlayer.create(this, R.raw.error_sound));
        sounds.put(getString(R.string.success_sound), MediaPlayer.create(this, R.raw.success_sound));
    }
}
