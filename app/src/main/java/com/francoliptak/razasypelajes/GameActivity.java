package com.francoliptak.razasypelajes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.francoliptak.razasypelajes.utils.ConfigPreferencesHandler;
import com.francoliptak.razasypelajes.utils.GameInitializer;
import com.francoliptak.razasypelajes.utils.Game;
import com.francoliptak.razasypelajes.utils.GamesController;
import com.francoliptak.razasypelajes.utils.GamesCreator;
import com.francoliptak.razasypelajes.utils.Horse;
import com.francoliptak.razasypelajes.utils.HorsesInformationProvider;
import com.francoliptak.razasypelajes.utils.Level;
import com.francoliptak.razasypelajes.utils.SoundManager;

import java.util.HashSet;
import java.util.List;

import static com.francoliptak.razasypelajes.utils.NameOfInteractions.IMG_WORD;
import static com.francoliptak.razasypelajes.utils.NameOfInteractions.WORD_IMG;

public class GameActivity extends AppCompatActivity {
    private TextView raceOfFurNameTextView; // Nombre de la raza del caballo a adivinar
    private MediaPlayer horseRaceOrFurNameSound; // Nombre del archivo de sonido del caballo a adivinar
    private Level actualLevelHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        associateSounds();
        startGame();
    }

    private void startGame(){
        List<Horse> horses = HorsesInformationProvider.getHorses(this);
        if(ConfigPreferencesHandler.selectedGameModeIsIW(this)){
            HashSet<Game> games = GamesCreator.getGames(horses, IMG_WORD);
            GamesController.playGames(this, games);
        }else{
            HashSet<Game> games = GamesCreator.getGames(horses, WORD_IMG);
            GamesController.playGames(this, games);
        }
    }

    public boolean selectedSoundIsFemale(){
        return ConfigPreferencesHandler.selectedAudioIsFamale(this);
    }

    public void setActualLevelHandler(Level actualLevelHandler) {
        this.actualLevelHandler = actualLevelHandler;
    }

    public void evaluateOptionChosen(View view){
        actualLevelHandler.evaluateOptionChosen(view, this);
    }

    public void goBack(View view){
        destroy();
    }

    public void destroy(){
        horseRaceOrFurNameSound = null;
        actualLevelHandler = null;
        finish();
    }

    @Override
    public void onBackPressed(){
        destroy();
    }

    private void associateSounds(){
        SoundManager.associateSounds(MediaPlayer.create(this, R.raw.success_sound),
                                     MediaPlayer.create(this, R.raw.error_sound));
    }
    public TextView getRaceOrFurNameTextView() {
        return raceOfFurNameTextView;
    }

    public void setHorseRaceOrFurNameSound(MediaPlayer horseRaceOrFurNameSound) {
        this.horseRaceOrFurNameSound = horseRaceOrFurNameSound;
    } // falta poder reproducirlo


}
