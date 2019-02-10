package com.francoliptak.razasypelajes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.francoliptak.razasypelajes.utils.ConfigPreferencesHandler;
import com.francoliptak.razasypelajes.utils.Horse;
import com.francoliptak.razasypelajes.utils.HorsesInformationProvider;
import com.francoliptak.razasypelajes.utils.RecognitionGridHandler;
import com.francoliptak.razasypelajes.utils.RecognitionListHandler;
import com.francoliptak.razasypelajes.utils.SoundManager;

import java.util.ArrayList;
import java.util.List;

public class RecognitionActivity extends AppCompatActivity {
    private ConfigPreferencesHandler configPreferencesHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configPreferencesHandler = new ConfigPreferencesHandler();
        List<Horse> horses = HorsesInformationProvider.getHorses(this);
        if (configPreferencesHandler.selectedModeIsList(this)) {
            RecognitionListHandler.show(this, horses);
        }else{
            RecognitionGridHandler.show(this, horses);
        }
    }

    public void playSounds(View view){
        view.setBackgroundResource(R.drawable.audio_click);
        ArrayList<MediaPlayer> lista = new ArrayList<>();
        lista.add((MediaPlayer) view.getTag()); // Tengo que modificar esto. La idea es que los caballos devuelvan una lista de sonidos (Raza y pelaje)
        SoundManager.playSounds(this, lista);
    }

    public void onBack(View view){
        if(configPreferencesHandler.selectedModeIsList(this)){
            findViewById(R.id.goHomeFromRL).setBackgroundResource(R.drawable.home_click);
        }else{
            findViewById(R.id.goHomeFromRG).setBackgroundResource(R.drawable.home_click);
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
