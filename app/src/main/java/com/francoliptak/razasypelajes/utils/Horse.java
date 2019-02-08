package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Horse {
    private String race;
    private String fur;
    private String description;
    @JsonProperty("image_name")
    private String imageName;
    @JsonProperty("sound_masculine_name")
    private String soundMasculineName;
    @JsonProperty("sound_feminine_name")
    private String soundFeminineName;
    @JsonIgnore
    private MediaPlayer soundMasculine;
    @JsonIgnore
    private MediaPlayer soundFeminine;

    public Horse() {
    }

    public Horse(String race, String fur, String description, String imageName, String soundMasculineName, String soundFeminineName) {
        this.race = race;
        this.fur = fur;
        this.description = description;
        this.imageName = imageName;
        this.soundMasculineName = soundMasculineName;
        this.soundFeminineName = soundFeminineName;
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

    public MediaPlayer getSoundMasculine() {
        return soundMasculine;
    }

    public void setSoundMasculine(MediaPlayer soundMasculine) {
        this.soundMasculine = soundMasculine;
    }

    public MediaPlayer getSoundFeminine() {
        return soundFeminine;
    }

    public void setSoundFeminine(MediaPlayer soundFeminine) {
        this.soundFeminine = soundFeminine;
    }

    public String getDescription() {
        return description;
    }

    public String getSoundMasculineName() {
        return soundMasculineName;
    }

    public void setSoundMasculineName(String soundMasculineName) {
        this.soundMasculineName = soundMasculineName;
    }

    public String getSoundFeminineName() {
        return soundFeminineName;
    }

    public void setSoundFeminineName(String soundFeminineName) {
        this.soundFeminineName = soundFeminineName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
