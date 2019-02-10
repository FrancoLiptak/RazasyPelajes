package com.francoliptak.razasypelajes.utils;

import android.widget.ImageView;
import android.widget.TextView;

public class RecognitionListItemData {
    private ImageView horseImageView;
    private ImageView horseSoundImageView;
    private TextView horseRaceFurNameTextView;
    private TextView horseDescriptionTextView;

    public RecognitionListItemData(ImageView horseImageView, ImageView horseSoundImageView, TextView horseRaceFurNameTextView, TextView horseDescriptionTextView) {
        this.horseImageView = horseImageView;
        this.horseSoundImageView = horseSoundImageView;
        this.horseRaceFurNameTextView = horseRaceFurNameTextView;
        this.horseDescriptionTextView = horseDescriptionTextView;
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

    public TextView getHorseDescriptionTextView() {
        return horseDescriptionTextView;
    }

    public void setHorseDescriptionTextView(TextView horseDescriptionTextView) {
        this.horseDescriptionTextView = horseDescriptionTextView;
    }
}
