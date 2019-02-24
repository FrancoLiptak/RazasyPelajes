package com.francoliptak.razasypelajes.utils;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.List;

public class Game {
    private Level levelOne;
    private GamesController gamesController;

    public Game(GamesController gamesController, List<Horse> horses, NameOfGames nameOfGame, NameOfInteractions nameOfInteraction, NameOfLevels nameOfLevel) {
        this.gamesController = gamesController;
        List<Level> levels = LevelsCreator.getLevels(horses, nameOfGame, nameOfInteraction, nameOfLevel, this); // Devuelve una lista por escalabilidad
        levelOne = levels.get(0);
    }

    public void playLevelOne(GameActivity gameActivity){
        gameActivity.setActualGameHandler(this);
        this.levelOne.playLevel(gameActivity);
    }

    public void informThatTheGameIsOver(GameActivity gameActivity){
        gamesController.playGameTwo(gameActivity);
    }

    public void informThatAllGamesWereFinished(GameActivity gameActivity){
        gameActivity.destroy();
    }

}
