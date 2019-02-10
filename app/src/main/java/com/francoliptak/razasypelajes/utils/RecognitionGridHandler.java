package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import com.francoliptak.razasypelajes.R;

import java.util.List;

public class RecognitionGridHandler extends RecognitionHandler {

    public RecognitionGridHandler(AppCompatActivity context) {
        super(context);
    }

    public static void show(AppCompatActivity anActivity, List<Horse> horses){
        anActivity.setContentView(R.layout.activity_recognition_grid);
        GridView gridView = anActivity.findViewById(R.id.gridView);
        RecognitionGridAdapter recognitionGridAdapter = new RecognitionGridAdapter(anActivity, R.layout.activity_recognition_grid_item, horses);
        gridView.setAdapter(recognitionGridAdapter);

    }
}
