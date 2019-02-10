package com.francoliptak.razasypelajes.utils;

import android.widget.ImageView;
import android.widget.TextView;

public class RecognitionGridItemData extends RecognitionItemData {

    public RecognitionGridItemData(ImageView horseImageView, ImageView horseSoundImageView, TextView horseRaceFurNameTextView) {
        super(horseImageView, horseSoundImageView, horseRaceFurNameTextView);
    }

    public TextView getHorseDescriptionTextView() {
        throw new UnsupportedOperationException();
    }

    public void setHorseDescriptionTextView(TextView horseDescriptionTextView) {
        throw new UnsupportedOperationException();
    }

}
