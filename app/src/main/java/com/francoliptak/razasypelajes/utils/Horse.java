package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Horse {
    private String race;
    private String fur;
    private String description;
    @JsonProperty("image_name")
    private String imageName;
    @JsonProperty("s_m_race_name")
    private String soundMasculineRaceName;
    @JsonProperty("s_f_race_name")
    private String soundFeminineRaceName;
    @JsonProperty("s_m_fur_name")
    private String soundMasculineFurName;
    @JsonProperty("s_f_fur_name")
    private String soundFeminineFurName;
    @JsonIgnore
    private int imageResourceId;
    @JsonIgnore
    private Integer masculineRaceSoundID;
    @JsonIgnore
    private Integer feminineRaceSoundID;
    @JsonIgnore
    private Integer masculineFurSoundID;
    @JsonIgnore
    private Integer feminineFurSoundID;

    public Horse() {
    }

    public Horse(String race, String fur, String description, String imageName, String soundMasculineRaceName, String soundFeminineRaceName, String soundMasculineFurName, String soundFeminineFurName) {
        this.race = race;
        this.fur = fur;
        this.description = description;
        this.imageName = imageName;
        this.soundMasculineRaceName = soundMasculineRaceName;
        this.soundFeminineRaceName = soundFeminineRaceName;
        this.soundMasculineFurName = soundMasculineFurName;
        this.soundFeminineFurName = soundFeminineFurName;
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

    public String getDescription() {
        return description;
    }

    public String getSoundMasculineRaceName() {
        return soundMasculineRaceName;
    }

    public void setSoundMasculineRaceName(String soundMasculineRaceName) {
        this.soundMasculineRaceName = soundMasculineRaceName;
    }

    public String getSoundFeminineRaceName() {
        return soundFeminineRaceName;
    }

    public void setSoundFeminineRaceName(String soundFeminineRaceName) {
        this.soundFeminineRaceName = soundFeminineRaceName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getSoundMasculineFurName() {
        return soundMasculineFurName;
    }

    public void setSoundMasculineFurName(String soundMasculineFurName) {
        this.soundMasculineFurName = soundMasculineFurName;
    }

    public String getSoundFeminineFurName() {
        return soundFeminineFurName;
    }

    public void setSoundFeminineFurName(String soundFeminineFurName) {
        this.soundFeminineFurName = soundFeminineFurName;
    }

    public Integer getMasculineRaceSoundID() {
        return masculineRaceSoundID;
    }

    public void setMasculineRaceSoundID(Integer masculineRaceSoundID) {
        this.masculineRaceSoundID = masculineRaceSoundID;
    }

    public Integer getFeminineRaceSoundID() {
        return feminineRaceSoundID;
    }

    public void setFeminineRaceSoundID(Integer feminineRaceSoundID) {
        this.feminineRaceSoundID = feminineRaceSoundID;
    }

    public Integer getMasculineFurSoundID() {
        return masculineFurSoundID;
    }

    public void setMasculineFurSoundID(Integer masculineFurSoundID) {
        this.masculineFurSoundID = masculineFurSoundID;
    }

    public Integer getFeminineFurSoundID() {
        return feminineFurSoundID;
    }

    public void setFeminineFurSoundID(Integer feminineFurSoundID) {
        this.feminineFurSoundID = feminineFurSoundID;
    }
}
