package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AcquirerOfJSONFiles {

    public static List<Horse> getHorses(AppCompatActivity anActivity, ObjectMapper objectMapper){
        try{
            InputStream is = anActivity.getAssets().open("horses.json");
            return objectMapper.readValue(is, new TypeReference<List<Horse>>(){});
        }catch (IOException e) {
            throw new RuntimeException("Error reading a jsonFile", e);
        }
    }
}
