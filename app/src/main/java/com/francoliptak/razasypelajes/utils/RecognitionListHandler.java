package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.francoliptak.razasypelajes.R;

import java.util.List;

public class RecognitionListHandler extends RecognitionHandler {

    public RecognitionListHandler(AppCompatActivity context) {
        super(context);
    }

    public static void show(AppCompatActivity anActivity, List horses){
        anActivity.setContentView(R.layout.activity_recognition_list);
        ListView listView = anActivity.findViewById(R.id.listView);
        RecognitionListAdapter recognitionListAdapter = new RecognitionListAdapter(anActivity, R.layout.activity_recognition_list_item, horses);
        listView.setAdapter(recognitionListAdapter);
    }
}
