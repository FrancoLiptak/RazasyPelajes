package com.francoliptak.razasypelajes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void goBack(View view){
        findViewById(R.id.aboutGoBack).setBackgroundResource(R.drawable.home_click);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
