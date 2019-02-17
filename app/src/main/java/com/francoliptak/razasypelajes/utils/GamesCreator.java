package com.francoliptak.razasypelajes.utils;

import java.util.ArrayList;
import java.util.List;

import static com.francoliptak.razasypelajes.utils.NameOfInteractions.IMG_WORD;
import static com.francoliptak.razasypelajes.utils.NameOfInteractions.WORD_IMG;
import static com.francoliptak.razasypelajes.utils.NameOfGames.MINIGAME_ONE;
import static com.francoliptak.razasypelajes.utils.NameOfGames.MINIGAME_TWO;

public class GamesCreator {

    public static List<Game> getGames(GamesController gamesController, List<Horse> horses, NameOfInteractions nameOfGameInteraction){
        List<Game> games = new ArrayList<>();
        switch (nameOfGameInteraction) {
            case IMG_WORD:
                games.add(new Game(gamesController, horses, MINIGAME_ONE, IMG_WORD));
                games.add(new Game(gamesController, horses, MINIGAME_TWO, IMG_WORD));
                break;
            case WORD_IMG:
                // games.add(new Game(gamesController, horses, MINIGAME_ONE, WORD_IMG));
                // games.add(new Game(gamesController, horses, MINIGAME_TWO, WORD_IMG));
                break;
        }
        return games;
    }
}
