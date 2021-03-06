package com.francoliptak.razasypelajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void redirectToGame(View view){
        findViewById(R.id.playGameButton).setBackgroundResource(R.drawable.ma_jugar_click);
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void redirectToRecognition(View view) {
        findViewById(R.id.recognitionButton).setBackgroundResource(R.drawable.ma_reconocimiento_click);
        Intent intent = new Intent(this, RecognitionActivity.class);
        startActivity(intent);
    }

    public void redirectToConfig(View view) {
        findViewById(R.id.settingsButton).setBackgroundResource(R.drawable.ma_config_click);
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
        findViewById(R.id.settingsButton).setBackgroundResource(R.drawable.ma_config_regular);
    }

    public void redirectToInfo(View view) {
        findViewById(R.id.infoButton).setBackgroundResource(R.drawable.ma_info_click);
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
        findViewById(R.id.infoButton).setBackgroundResource(R.drawable.ma_info_regular);
    }

}
