package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;

public class Horse {
    private String race;
    private String fur;
    private String imageName;
    private MediaPlayer soundName;

    public Horse() {
    }

    public Horse(String race, String fur, String imageName, MediaPlayer sound) {
        this.race = race;
        this.fur = fur;
        this.imageName = imageName;
        this.soundName = sound;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public MediaPlayer getSoundName() {
        return soundName;
    }

    public void setSoundName(MediaPlayer soundName) {
        this.soundName = soundName;
    }
}
