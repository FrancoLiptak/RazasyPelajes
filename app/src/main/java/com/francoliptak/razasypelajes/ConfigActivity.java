package com.francoliptak.razasypelajes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.francoliptak.razasypelajes.utils.GameModeCheckbox;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConfigActivity extends AppCompatActivity {
    private Switch levelSwitch;
    private Switch sexSwitch;
    private RadioGroup minijuegoRadio;
    private RadioGroup viewModeRadio;
    private RadioGroup modoInteraccionRadio;
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
        minijuegoRadio.check(preferences.getInt(getString(R.string.config_preferences_minijuego), R.id.razasYPelajesRadioButton));
        viewModeRadio.check(preferences.getInt(getString(R.string.config_preferences_view_mode), R.id.listaRadioButton));
        modoInteraccionRadio.check(preferences.getInt(getString(R.string.config_preferences_interaction_mode), R.id.interaccionARadioButton));
        GameModeCheckbox.check(this);
    }

    private void associateViewsToVariables(){
        modoInteraccionRadio = findViewById(R.id.ModoInteraccion);
        levelSwitch = findViewById(R.id.Level);
        sexSwitch = findViewById(R.id.Sex);
        minijuegoRadio = findViewById(R.id.Minijuego);
        viewModeRadio = findViewById(R.id.ViewMode);
        GameModeCheckbox.associate(this);
    }

    public void onAccept(View view) {
        SharedPreferences.Editor editor = this.getPreferences().edit();
        editor.putBoolean(getString(R.string.config_preferences_sex), sexSwitch.isChecked());
        editor.putBoolean(getString(R.string.config_preferences_level), levelSwitch.isChecked());
        editor.putInt(getString(R.string.config_preferences_minijuego), minijuegoRadio.getCheckedRadioButtonId());
        editor.putInt(getString(R.string.config_preferences_view_mode), viewModeRadio.getCheckedRadioButtonId());
        editor.putInt(getString(R.string.config_preferences_interaction_mode), modoInteraccionRadio.getCheckedRadioButtonId());

        HashSet<String> selectedGameModes = new HashSet<>();
        for (Map.Entry<String, CheckBox> entry : gameModeCheckBox.entrySet())
            if (entry.getValue().isChecked()) selectedGameModes.add(entry.getKey());
        editor.putStringSet(getString(R.string.gameMode), selectedGameModes);

        editor.apply();
        finish();
    }
}
