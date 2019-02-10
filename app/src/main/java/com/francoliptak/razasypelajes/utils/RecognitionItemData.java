package com.francoliptak.razasypelajes.utils;

import android.widget.ImageView;
import android.widget.TextView;

public abstract class RecognitionItemData {
    private ImageView horseImageView;
    private ImageView horseSoundImageView;
    private TextView horseRaceFurNameTextView;

    public RecognitionItemData(ImageView horseImageView, ImageView horseSoundImageView, TextView horseRaceFurNameTextView) {
        this.horseImageView = horseImageView;
        this.horseSoundImageView = horseSoundImageView;
        this.horseRaceFurNameTextView = horseRaceFurNameTextView;
    }

    public ImageView getHorseImageView() {
        return horseImageView;
    }

    public void setHorseImageView(ImageView horseImageView) {
        this.horseImageView = horseImageView;
    }

    public ImageView getHorseSoundImageView() {
        return horseSoundImageView;
    }

    public void setHorseSoundImageView(ImageView horseSoundImageView) {
        this.horseSoundImageView = horseSoundImageView;
    }

    public TextView getHorseRaceFurNameTextView() {
        return horseRaceFurNameTextView;
    }

    public void setHorseRaceFurNameTextView(TextView horseRaceFurNameTextView) {
        this.horseRaceFurNameTextView = horseRaceFurNameTextView;
    }

    public abstract TextView getHorseDescriptionTextView();

    public abstract void setHorseDescriptionTextView(TextView horseDescriptionTextView);
}
