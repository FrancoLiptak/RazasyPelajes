package com.francoliptak.razasypelajes.utils;

import com.francoliptak.razasypelajes.GameActivity;

import java.util.List;

public class GameOneLevelTwoIW extends Level{
    private List<Horse> horses;

    public GameOneLevelTwoIW(List<Horse> horses) {
        this.horses = horses;
    }

    public boolean playLevelAndReportSuccessOrNot(GameActivity gameActivity){
        return false;
    }
}
