package com.francoliptak.razasypelajes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.francoliptak.razasypelajes.utils.Horse;
import com.francoliptak.razasypelajes.utils.HorsesInformationProvider;

import java.util.List;

public class RecognitionActivity extends AppCompatActivity {
    private MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognition_grid);
        List<Horse> horses = HorsesInformationProvider.getHorses(this);
        ImageView imageView = (ImageView) findViewById(R.id.imageView19);
        Horse horse = horses.get(3);
        int id = getResources().getIdentifier(horse.getImageName(), "drawable", getPackageName());
        imageView.setImageResource(id);
        sound = horse.getSoundMasculine();
    }

    public void playSound(View view){
        sound.start();
    }
}
