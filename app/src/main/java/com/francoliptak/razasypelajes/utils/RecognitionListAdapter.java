package com.francoliptak.razasypelajes.utils;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.francoliptak.razasypelajes.R;

import java.util.List;

public class RecognitionListAdapter extends ArrayAdapter<Horse> {
    private AppCompatActivity anActivity;
    private int layoutId;
    private List<Horse> horses;

    public RecognitionListAdapter(AppCompatActivity anActivity, int layoutId, List<Horse> horses) {
        super(anActivity, layoutId, horses);

        this.anActivity = anActivity;
        this.layoutId = layoutId;
        this.horses = horses;
    }

    static class DataHolder{
        ImageView horseImageView, soundImgView;
        TextView horseTextView, horseTxtTextView;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataHolder dataHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = anActivity.getLayoutInflater();
            convertView = layoutInflater.inflate(layoutId, parent, false);
            dataHolder = new DataHolder();
            dataHolder.horseImageView = convertView.findViewById(R.id.listItemPhoto);
            dataHolder.soundImgView = convertView.findViewById(R.id.listItemPlaySound);
            dataHolder.horseTextView = convertView.findViewById(R.id.listItemRaceName);
            dataHolder.horseTxtTextView = convertView.findViewById(R.id.listItemRaceDescription);
            convertView.setTag(dataHolder);
        }else{
            dataHolder = (DataHolder) convertView.getTag();
        }
        Horse horse = horses.get(position);
        dataHolder.horseTextView.setText(horse.getRace());
        dataHolder.horseTxtTextView.setText(horse.getDescription());
        dataHolder.horseImageView.setImageResource(horse.getImageResourceId());
        // dataHolder.horseImageView.setTag(horse.getImageResourceId()); //Creo que es cuando la img se agranda
        if(ConfigPreferencesHandler.selectedAudioIsFamale(anActivity)){
            dataHolder.soundImgView.setTag(horse.getSoundMasculine());
        }else{
            dataHolder.soundImgView.setTag(horse.getSoundFeminine());
        }
        return convertView;
    }
}
