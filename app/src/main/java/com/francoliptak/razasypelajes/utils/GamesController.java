package com.francoliptak.razasypelajes.utils;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.HashSet;

public class GamesController {

    private static boolean lostGame = false;
    private static int successfulGames = 0;

    public static void playGames(GameActivity gameActivity, HashSet<Game> gameHashSet){
        while((!lostGame) || successfulGames != gameHashSet.size()){
            for(Game game : gameHashSet){
                boolean success = game.playGameAndReportSuccessOrNot(gameActivity);
                if(!success){
                    lostGame = true;
                    break;
                }else{
                    successfulGames++;
                }
            }
        }
        if(successfulGames == gameHashSet.size()){
            gameActivity.showTrophy();
        }else{
            gameActivity.destroy();
        }
    }
}
