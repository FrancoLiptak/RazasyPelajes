package com.francoliptak.razasypelajes;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.utils.ConfigPreferencesHandler;
import com.francoliptak.razasypelajes.utils.Game;
import com.francoliptak.razasypelajes.utils.GamesController;
import com.francoliptak.razasypelajes.utils.Horse;
import com.francoliptak.razasypelajes.utils.HorsesInformationProvider;
import com.francoliptak.razasypelajes.utils.Level;
import com.francoliptak.razasypelajes.utils.SoundManager;

import java.util.ArrayList;
import java.util.List;

import static com.francoliptak.razasypelajes.utils.NameOfInteractions.IMG_WORD;
import static com.francoliptak.razasypelajes.utils.NameOfInteractions.WORD_IMG;

public class GameActivity extends AppCompatActivity {
    private List<MediaPlayer> horseRaceOrFurNameSounds;
    private Level actualLevelHandler;
    private Game actualGameHandler;
    private AnimationDrawable confettiAnimation, trophyAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        associateSounds();
        startGame();
    }

    private void startGame(){
        List<Horse> horses = HorsesInformationProvider.getHorses(this);
        if(ConfigPreferencesHandler.selectedGameModeIsIW(this)){
            GamesController gamesController = new GamesController(horses, IMG_WORD);
            gamesController.playGameOne(this);
        }else{
            GamesController gamesController = new GamesController(horses, WORD_IMG);
            gamesController.playGameOne(this);
        }
    }

    public boolean selectedSoundIsFemale(){
        return ConfigPreferencesHandler.selectedAudioIsFamale(this);
    }

    public void setActualLevelHandler(Level actualLevelHandler) {
        this.actualLevelHandler = actualLevelHandler;
    }

    public void setActualGameHandler(Game actualGameHandler) {
        this.actualGameHandler = actualGameHandler;
    }

    public void evaluateOptionChosen(View view){
        actualLevelHandler.evaluateOptionChosen(view, this);
    }

    public void goBack(View view){
        destroy();
    }

    public void destroy(){
        horseRaceOrFurNameSounds = null;
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

    public void setHorseRaceOrFurNameSounds(List<MediaPlayer> horseRaceOrFurNameSound) {
        this.horseRaceOrFurNameSounds = horseRaceOrFurNameSound;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void playHorseRaceOrFurNameSound(View view){
        SoundManager.playSounds(this.horseRaceOrFurNameSounds);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void playSounds(View view){
        view.setBackgroundResource(R.drawable.audio_click);
        SoundManager.playSounds((ArrayList<MediaPlayer>) view.getTag());
    }

    public void retryLevel(View view){
        this.actualLevelHandler.playLevel(this);
    }

    public void goToNextLevel(View view){
        this.actualLevelHandler.nextStep(this, actualGameHandler);
    }

    public void retryAllGames(View view){
        startGame();
    }


    public void showMenuAndAnimation(){
        setContentView(R.layout.menu_game);
        startConfettiAnimation();
    }

    public void showFinalMenuAndAnimation(){
        setContentView(R.layout.final_menu_game);
        startTrophyAnimation();
    }

    public void startConfettiAnimation(){
        ImageView confettiImgView = (ImageView) findViewById(R.id.confettiImageView);
        confettiImgView.setBackgroundResource(R.drawable.anim_confetti);
        confettiAnimation = (AnimationDrawable) confettiImgView.getBackground();
        confettiAnimation.setOneShot(true);
        confettiAnimation.start();
    }

    public void startTrophyAnimation() {
        ImageView trophyImgView = (ImageView) findViewById(R.id.trophyImageView);
        trophyImgView.setBackgroundResource(R.drawable.anim_trophy);
        trophyAnimation = (AnimationDrawable) trophyImgView.getBackground();
        trophyAnimation.setOneShot(true);
        trophyAnimation.start();
    }

}