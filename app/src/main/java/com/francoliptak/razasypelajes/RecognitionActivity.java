package com.francoliptak.razasypelajes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.francoliptak.razasypelajes.utils.Horse;
import com.francoliptak.razasypelajes.utils.HorsesInformationProvider;
import com.francoliptak.razasypelajes.utils.RecognitionGridHandler;
import com.francoliptak.razasypelajes.utils.RecognitionListHandler;

import java.util.List;

public class RecognitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Horse> horses = HorsesInformationProvider.getHorses(this);
        if (listModeSelected()) {
            RecognitionListHandler.show(this, horses);
        }else{
            RecognitionGridHandler.show(this, horses);
        }
    }

    private SharedPreferences getConfigSharedPrefs(){
        return getSharedPreferences(getString(R.string.config_preferences), Context.MODE_PRIVATE);
    }

    private Boolean listModeSelected() {
        return  getConfigSharedPrefs().getInt(getString(R.string.config_preferences_recognition_mode), R.id.listRadioButton)
                == R.id.listRadioButton;
    }

    public void onBack(View view){
        if(listModeSelected()){
            findViewById(R.id.goHomeFromRL).setBackgroundResource(R.drawable.home_click);
        }else{
            findViewById(R.id.goHomeFromRG).setBackgroundResource(R.drawable.home_click);
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
