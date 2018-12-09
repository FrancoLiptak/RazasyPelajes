package com.francoliptak.razasypelajes.utils;

public class Horse {
    private String race;
    private String fur;
    private String image;

    public Horse() {
    }

    public Horse(String race, String fur, String image) {
        this.race = race;
        this.fur = fur;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
