package com.francoliptak.razasypelajes.utils;

import java.util.HashSet;
import java.util.List;

import static com.francoliptak.razasypelajes.utils.NameOfInteractions.IMG_WORD;
import static com.francoliptak.razasypelajes.utils.NameOfInteractions.WORD_IMG;

public class LevelsCreator {

    public static HashSet<Level> getLevels(List<Horse> horses, NameOfGames nameOfGame, NameOfInteractions nameOfInteraction){
        HashSet<Level> levelHashSet = new HashSet<>();
        createLevels(levelHashSet, nameOfGame, nameOfInteraction, horses);
        return levelHashSet;
    }

    private static void createLevels(HashSet<Level> levelHashSet, NameOfGames nameOfGame, NameOfInteractions nameOfInteraction, List<Horse> horses){
        switch (nameOfGame) {
            case MINIGAME_ONE:
                switch (nameOfInteraction) {
                    case IMG_WORD:
                        levelHashSet.add(new GameOneLevelOneIW(horses));
                        levelHashSet.add(new GameOneLevelTwoIW(horses));
                    case WORD_IMG:
                        levelHashSet.add(new GameOneLevelOneWI(horses));
                        levelHashSet.add(new GameOneLevelTwoWI(horses));
                }
            case MINIGAME_TWO:
                switch (nameOfInteraction) {
                    case IMG_WORD:
                        levelHashSet.add(new GameTwoLevelOneIW(horses));
                        levelHashSet.add(new GameTwoLevelTwoIW(horses));
                    case WORD_IMG:
                        levelHashSet.add(new GameTwoLevelOneWI(horses));
                        levelHashSet.add(new GameTwoLevelTwoWI(horses));
                }

        }
    }

}
