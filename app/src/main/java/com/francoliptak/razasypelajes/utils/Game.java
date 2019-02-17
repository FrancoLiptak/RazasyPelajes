package com.francoliptak.razasypelajes.utils;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.List;

public class Game {
    private Level levelOne;
    private Level levelTwo;
    private GamesController gamesController;

    public Game(GamesController gamesController, List<Horse> horses, NameOfGames nameOfGame, NameOfInteractions nameOfInteraction) {
        this.gamesController = gamesController;
        List<Level> levels = LevelsCreator.getLevels(horses, nameOfGame, nameOfInteraction, this);
        levelOne = levels.get(0);
        levelTwo = levels.get(1);
    }

    public void playLevelOne(GameActivity gameActivity){
        this.levelOne.playLevel(gameActivity);
    }

    public void playLevelTwo(GameActivity gameActivity){
        this.levelTwo.playLevel(gameActivity);
    }

    public void informThatTheGameIsOver(GameActivity gameActivity){
        gamesController.playGameTwo(gameActivity);
    }

    public void informThatAllGamesWereFinished(GameActivity gameActivity){
        gameActivity.destroy();
    }

}
