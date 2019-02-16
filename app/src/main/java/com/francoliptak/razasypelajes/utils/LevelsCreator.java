package com.francoliptak.razasypelajes.utils;

import java.util.HashSet;
import java.util.List;

import static com.francoliptak.razasypelajes.utils.GameInterfaces.IMG_WORD;
import static com.francoliptak.razasypelajes.utils.GameInterfaces.WORD_IMG;
import static com.francoliptak.razasypelajes.utils.Games.MINIGAME_ONE;
import static com.francoliptak.razasypelajes.utils.Games.MINIGAME_TWO;

public class LevelsCreator {

    public static HashSet<Level> getLevels(Enum game, Enum gameLevel, List<Horse> horses){
        HashSet<Level> levelHashSet = new HashSet<>();
        createLevels(levelHashSet, game, gameLevel, horses);
        return levelHashSet;
    }

    private static void createLevels(HashSet<Level> levelHashSet, Enum game, Enum gameInterface, List<Horse> horses){
        switch (game) {
            case MINIGAME_ONE:
                switch (gameInterface) {
                    case IMG_WORD:
                        levelHashSet.add(new GameOneLevelOneIW(horses));
                        levelHashSet.add(new GameOneLevelTwoIW(horses));
                    case WORD_IMG:
                        levelHashSet.add(new GameOneLevelOneWI(horses));
                        levelHashSet.add(new GameOneLevelTwoWI(horses));
                }
            case MINIGAME_TWO:
                switch (gameInterface) {
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
