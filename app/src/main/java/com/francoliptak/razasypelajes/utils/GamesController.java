package com.francoliptak.razasypelajes.utils;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.List;

public class GamesController {
    private Game gameOne;
    private Game gameTwo;

    public GamesController(List<Horse> horses, NameOfInteractions nameOfGameInteraction) {
        List<Game> games = GamesCreator.getGames(this, horses, nameOfGameInteraction);
        this.gameOne = games.get(0);
        this.gameTwo = games.get(1);
    }

    public void playGameOne(GameActivity gameActivity){
        this.gameOne.playLevelOne(gameActivity);
    }

    public void playGameTwo(GameActivity gameActivity){
        this.gameTwo.playLevelOne(gameActivity);
    }
}
