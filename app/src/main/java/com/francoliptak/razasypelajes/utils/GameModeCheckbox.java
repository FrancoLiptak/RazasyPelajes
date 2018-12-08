package com.francoliptak.razasypelajes.utils;

import android.widget.CheckBox;

import com.francoliptak.razasypelajes.ConfigActivity;
import com.francoliptak.razasypelajes.R;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameModeCheckbox {
    private static Map<String, CheckBox> gameModeCheckBox = new HashMap<>();

    public static void associate(ConfigActivity configActivity){
        gameModeCheckBox.put(configActivity.getString(R.string.razasCheckbox), (CheckBox) configActivity.findViewById(R.id.razasCheckbox));
        gameModeCheckBox.put(configActivity.getString(R.string.pelajesCheckbox), (CheckBox) configActivity.findViewById(R.id.pelajesCheckbox));
        gameModeCheckBox.put(configActivity.getString(R.string.cruzasCheckbox), (CheckBox) configActivity.findViewById(R.id.cruzasCheckbox));
    }

    public static String getSelectedCheckboxByDefault(ConfigActivity configActivity){
        return configActivity.getString(R.string.razasCheckbox);
    }

    public static void check(ConfigActivity configActivity){
        for (CheckBox checkBox : gameModeCheckBox.values()) checkBox.setChecked(false);

        Set<String> gameModes = configActivity.getPreferences().getStringSet(configActivity.getString(R.string.config_preferences_game_mode), new HashSet<String>());

        Boolean someWasSelected = false;
        if (gameModes != null){
            for (String checkBoxKey : gameModes) {
                CheckBox ck = gameModeCheckBox.get(checkBoxKey);
                if (ck != null){
                    someWasSelected = true;
                    ck.setChecked(true);
                }
            }
        }else if(!someWasSelected){
            gameModeCheckBox.get(getSelectedCheckboxByDefault(configActivity)).setChecked(true);
        }
    }

    public static Set<String> getSelectedGameModes(){
        Set<String> selectedGameModes = new HashSet<>();
        for (Map.Entry<String, CheckBox> entry : gameModeCheckBox.entrySet())
            if (entry.getValue().isChecked()) selectedGameModes.add(entry.getKey());
        return selectedGameModes;
    }
}
