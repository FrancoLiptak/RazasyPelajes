package com.francoliptak.razasypelajes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;


public class ConfigActivity extends AppCompatActivity {
    private Switch levelSwitch;
    private Switch sexSwitch;
    private RadioGroup minijuegoRadio;
    private RadioGroup recognitionMode;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        preferences = getSharedPreferences(getString(R.string.config_preferences), Context.MODE_PRIVATE);
        associateViewsToVariables();
        setValues();
    }

    public SharedPreferences getPreferences(){
        return preferences;
    }

    private void setValues(){
        levelSwitch.setChecked(preferences.getBoolean(getString(R.string.config_preferences_level), false));
        sexSwitch.setChecked(preferences.getBoolean(getString(R.string.config_preferences_sex), true));
        minijuegoRadio.check(preferences.getInt(getString(R.string.config_preferences_mini_juego), R.id.imgWord));
        recognitionMode.check(preferences.getInt(getString(R.string.config_preferences_recognition_mode), R.id.listRadioButton));
    }

    private void associateViewsToVariables(){
        levelSwitch = findViewById(R.id.label_switch);
        sexSwitch = findViewById(R.id.sex_witch);
        minijuegoRadio = findViewById(R.id.mini_juego_radio);
        recognitionMode = findViewById(R.id.recognition_mode);
    }

    public void onAccept(View view) {
        SharedPreferences.Editor editor = this.getPreferences().edit();
        editor.putBoolean(getString(R.string.config_preferences_sex), sexSwitch.isChecked());
        editor.putBoolean(getString(R.string.config_preferences_level), levelSwitch.isChecked());
        editor.putInt(getString(R.string.config_preferences_mini_juego), minijuegoRadio.getCheckedRadioButtonId());
        editor.putInt(getString(R.string.config_preferences_recognition_mode), recognitionMode.getCheckedRadioButtonId());

        editor.apply();
        finish();
    }
}
