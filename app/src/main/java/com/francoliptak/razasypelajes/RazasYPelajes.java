package com.francoliptak.razasypelajes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class RazasYPelajes extends AppCompatActivity {
    private List<ImageView> horsesViews;
    private Map<String, MediaPlayer> songs;
    private TextView horseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.razas_y_pelajes);

    }

}
