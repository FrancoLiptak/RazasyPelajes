package com.francoliptak.razasypelajes.utils;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.R;

import java.util.ArrayList;
import java.util.List;

public class RecognitionListAdapter extends RecognitionAdapter {

    public RecognitionListAdapter(AppCompatActivity anActivity, int layoutId, List<Horse> horses) {
        super(anActivity, layoutId, horses);
    }

    protected RecognitionListItemData getItemsAndSetTagToConvertView(View convertView) {
        RecognitionListItemData recognitionListItemData = new RecognitionListItemData(
                (ImageView) convertView.findViewById(R.id.listItemPhoto),
                (ImageView) convertView.findViewById(R.id.listItemPlaySound),
                (TextView)  convertView.findViewById(R.id.listItemRaceName),
                (TextView)  convertView.findViewById(R.id.listItemRaceDescription)
        );
        convertView.setTag(recognitionListItemData);
        return recognitionListItemData;
    }

    protected void setDataToViews(AppCompatActivity anActivity, List<Horse> horses, int position, RecognitionItemData recognitionListItemData){
        Horse horse = horses.get(position);
        recognitionListItemData.getHorseRaceFurNameTextView().setText(horse.getRace() + " - " + horse.getFur());
        recognitionListItemData.getHorseDescriptionTextView().setText(horse.getDescription());
        recognitionListItemData.getHorseImageView().setImageResource(horse.getImageResourceId());
        recognitionListItemData.getHorseImageView().setTag(horse.getImageResourceId());

        if(ConfigPreferencesHandler.selectedAudioIsFamale(anActivity)){
            List<Integer> sounds = new ArrayList<>();
            sounds.add(horse.getFeminineRaceSoundID());
            sounds.add(horse.getFeminineFurSoundID());
            recognitionListItemData.getHorseSoundImageView().setTag(sounds);
        }else{
            List<Integer> sounds = new ArrayList<>();
            sounds.add(horse.getMasculineRaceSoundID());
            sounds.add(horse.getMasculineFurSoundID());
            recognitionListItemData.getHorseSoundImageView().setTag(sounds);
        }
    }
}
