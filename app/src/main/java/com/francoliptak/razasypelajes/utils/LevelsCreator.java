package com.francoliptak.razasypelajes.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.francoliptak.razasypelajes.utils.NameOfInteractions.IMG_WORD;
import static com.francoliptak.razasypelajes.utils.NameOfInteractions.WORD_IMG;

public class LevelsCreator {

    public static List<Level> getLevels(List<Horse> horses, NameOfGames nameOfGame, NameOfInteractions nameOfInteraction, Game game){
        List<Level> levels = new ArrayList<>();
        createLevels(levels, nameOfGame, nameOfInteraction, horses, game);
        return levels;
    }

    private static void createLevels(List<Level> levels, NameOfGames nameOfGame, NameOfInteractions nameOfInteraction, List<Horse> horses, Game game){
        switch (nameOfGame) {
            case MINIGAME_ONE:
                switch (nameOfInteraction) {
                    case IMG_WORD:
                        levels.add(new GameOneLevelOneIW(game, horses, IMG_WORD));
                        levels.add(new GameOneLevelTwoIW(game, horses, IMG_WORD));
                    case WORD_IMG:
                        levels.add(new GameOneLevelOneWI(game, horses, WORD_IMG));
                        levels.add(new GameOneLevelTwoWI(game, horses, WORD_IMG));
                }

            case MINIGAME_TWO:
                switch (nameOfInteraction) {
                    case IMG_WORD:
                        levels.add(new GameTwoLevelOneIW(game, horses, IMG_WORD));
                        levels.add(new GameTwoLevelTwoIW(game, horses, IMG_WORD));
                    case WORD_IMG:
                        levels.add(new GameTwoLevelOneWI(game, horses, WORD_IMG));
                        levels.add(new GameTwoLevelTwoWI(game, horses, WORD_IMG));
                }
        }
    }

}
