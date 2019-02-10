package com.francoliptak.razasypelajes.utils;

import android.app.LauncherActivity;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class RecognitionListAdapter extends ArrayAdapter<LauncherActivity.ListItem> {
    private Context context;
    private int layoutId;
    private List horses;

    public RecognitionListAdapter(Context context, int resource, List horses) {
        super(context, resource, horses);

        this.context = context;
        this.layoutId = resource;
        this.horses = horses;
    }
}
