package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class RecognitionGridAdapter extends RecognitionAdapter {

    public RecognitionGridAdapter(AppCompatActivity anActivity, int layoutId, List<Horse> horses) {
        super(anActivity, layoutId, horses);
    }

    protected RecognitionItemData getItemsAndSetTagToConvertView(View convertView) {
        RecognitionGridItemData recognitionGridItemData = new RecognitionGridItemData(
                (ImageView) convertView.findViewById(R.id.gridItemPhoto),
                (ImageView) convertView.findViewById(R.id.gridItemPlaySound),
                (TextView)  convertView.findViewById(R.id.gridItemRaceName)
        );
        convertView.setTag(recognitionGridItemData);
        return recognitionGridItemData;
    }

    protected void setDataToViews(AppCompatActivity anActivity, List<Horse> horses, int position, RecognitionItemData recognitionGridItemData){
        Horse horse = horses.get(position);
        recognitionGridItemData.getHorseRaceFurNameTextView().setText(horse.getRace() + " " + horse.getFur());
        recognitionGridItemData.getHorseImageView().setImageResource(horse.getImageResourceId());
        recognitionGridItemData.getHorseImageView().setTag(horse.getImageResourceId());

        if(ConfigPreferencesHandler.selectedAudioIsFamale(anActivity)){
            List<MediaPlayer> sounds = new ArrayList<>();
            sounds.add(horse.getSoundFeminineRace());
            sounds.add(horse.getSoundFeminineFur());
            recognitionGridItemData.getHorseSoundImageView().setTag(sounds);
        }else{
            List<MediaPlayer> sounds = new ArrayList<>();
            sounds.add(horse.getSoundMasculineRace());
            sounds.add(horse.getSoundMasculineFur());
            recognitionGridItemData.getHorseSoundImageView().setTag(sounds);
        }
    }
}
