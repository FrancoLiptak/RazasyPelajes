package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public abstract class RecognitionAdapter extends ArrayAdapter<Horse> {
    private AppCompatActivity anActivity;
    private int layoutId;
    private List<Horse> horses;

    public RecognitionAdapter(AppCompatActivity anActivity, int layoutId, List<Horse> horses) {
        super(anActivity, layoutId, horses);

        this.anActivity = anActivity;
        this.layoutId = layoutId;
        this.horses = horses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecognitionItemData recognitionItemData;
        if (convertView == null){
            LayoutInflater layoutInflater = anActivity.getLayoutInflater();
            convertView = layoutInflater.inflate(layoutId, parent, false);
            recognitionItemData = this.getItemsAndSetTagToConvertView(convertView);
        }else{
            recognitionItemData = (RecognitionItemData) convertView.getTag();
        }
        this.setDataToViews(anActivity, horses, position, recognitionItemData);
        return convertView;
    }

    protected abstract RecognitionItemData getItemsAndSetTagToConvertView(View convertView);

    protected abstract void setDataToViews(AppCompatActivity anActivity, List<Horse> horses, int position, RecognitionItemData recognitionListItemData);

}
