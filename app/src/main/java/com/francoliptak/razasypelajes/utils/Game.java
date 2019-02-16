package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.HashSet;

public class Game {
    private HashSet<Level> levelHashSet;
    private boolean lostGame;
    private int successfulLevels;

    public Game(HashSet<Level> levelHashSet) {
        this.levelHashSet = levelHashSet;
        this.lostGame = false;
        this.successfulLevels = 0;
    }

    public boolean playGameAndReportSuccessOrNot(GameActivity gameActivity){
        while((!lostGame) || successfulLevels != levelHashSet.size()){
            for(Level level : levelHashSet){
                boolean success = level.playLevelAndReportSuccessOrNot(gameActivity);
                if(!success){
                    lostGame = true;
                    break;
                }else{
                    successfulLevels++;
                }
            }
        }

        return successfulLevels == levelHashSet.size();
    }

}
