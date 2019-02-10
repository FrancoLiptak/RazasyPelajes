package com.francoliptak.razasypelajes.utils;

import android.widget.ImageView;
import android.widget.TextView;

public class RecognitionListItemData extends RecognitionItemData{
    private TextView horseDescriptionTextView;

    public RecognitionListItemData(ImageView horseImageView, ImageView horseSoundImageView, TextView horseRaceFurNameTextView, TextView horseDescriptionTextView) {
        super(horseImageView, horseSoundImageView, horseRaceFurNameTextView);
        this.horseDescriptionTextView = horseDescriptionTextView;
    }

    public TextView getHorseDescriptionTextView() {
        return horseDescriptionTextView;
    }

    public void setHorseDescriptionTextView(TextView horseDescriptionTextView) {
        this.horseDescriptionTextView = horseDescriptionTextView;
    }
}
