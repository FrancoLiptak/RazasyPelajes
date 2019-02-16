package com.francoliptak.razasypelajes.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.francoliptak.razasypelajes.R;

public class ConfigPreferencesHandler {

    private static SharedPreferences getSharedPreferences(AppCompatActivity anActivity){
        return anActivity.getSharedPreferences(anActivity.getString(R.string.config_preferences), Context.MODE_PRIVATE);
    }

    public static Boolean selectedModeIsList(AppCompatActivity anActivity) {
        return getSharedPreferences(anActivity).getInt(anActivity.getString(R.string.config_preferences_recognition_mode), R.id.listRadioButton)
                == R.id.listRadioButton;
    }

    public static Boolean selectedModeIsGrid(AppCompatActivity anActivity) {
        return getSharedPreferences(anActivity).getInt(anActivity.getString(R.string.config_preferences_recognition_mode), R.id.gridRadioButton)
                == R.id.gridRadioButton;
    }

    public static Boolean selectedAudioIsFamale(AppCompatActivity anActivity){
        return getSharedPreferences(anActivity).getBoolean(anActivity.getString(R.string.config_preferences_sex), false);
    }

    public static Boolean selectedAudioIsMasculine(AppCompatActivity anActivity){
        return !getSharedPreferences(anActivity).getBoolean(anActivity.getString(R.string.config_preferences_sex), false);
    }

    public static Boolean selectedGameModeIsWI(AppCompatActivity anActivity){
        RadioGroup minijuegoRadio = anActivity.findViewById(R.id.mini_juego_radio);
        return getSharedPreferences(anActivity).getInt(anActivity.getString(R.string.config_preferences_mini_juego), R.id.wordImg)
                ==
                minijuegoRadio.getCheckedRadioButtonId();
    }

    public static Boolean selectedGameModeIsIW(AppCompatActivity anActivity){
        return getSharedPreferences(anActivity).getInt(anActivity.getString(R.string.config_preferences_mini_juego), R.id.imgWord)
                ==
                R.id.imgWord;
    }

}
