package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.HashSet;

public class GameController {
    private static boolean lostGame = false;
    private static int successfulLevels = 0;

    public static void playGame(GameActivity gameActivity, HashSet<Level> levelList){
        while((!lostGame) || successfulLevels != levelList.size()){
            for(Level level : levelList){
                boolean success = level.playLevelAndReportSuccessOrNot(gameActivity);
                if(!success){
                    lostGame = true;
                    break;
                }else{
                    successfulLevels++;
                }
            }
        }
        if(successfulLevels == levelList.size()){
            gameActivity.playNextGame();
        }else{
            gameActivity.destroy();
        }
    }

}
