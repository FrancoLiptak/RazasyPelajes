package com.francoliptak.razasypelajes.utils;

import java.util.HashSet;
import java.util.List;

import static com.francoliptak.razasypelajes.utils.NameOfInteractions.IMG_WORD;
import static com.francoliptak.razasypelajes.utils.NameOfInteractions.WORD_IMG;
import static com.francoliptak.razasypelajes.utils.NameOfGames.MINIGAME_ONE;
import static com.francoliptak.razasypelajes.utils.NameOfGames.MINIGAME_TWO;

public class GamesCreator {

    public static HashSet<Game> getGames(List<Horse> horses, NameOfInteractions nameOfGameInteraction){
        HashSet<Game> gameHashSet = new HashSet<>();
        switch (nameOfGameInteraction) {
            case IMG_WORD:
                gameHashSet.add(new Game(LevelsCreator.getLevels(horses, MINIGAME_ONE, IMG_WORD)));
                gameHashSet.add(new Game(LevelsCreator.getLevels(horses, MINIGAME_TWO, IMG_WORD)));
                break;
            case WORD_IMG:
                gameHashSet.add(new Game(LevelsCreator.getLevels(horses, MINIGAME_ONE, WORD_IMG)));
                gameHashSet.add(new Game(LevelsCreator.getLevels(horses, MINIGAME_TWO, WORD_IMG)));
                break;
        }
        return gameHashSet;
    }
}
