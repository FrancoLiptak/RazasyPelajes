package com.francoliptak.razasypelajes.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.francoliptak.razasypelajes.MainActivity;
import com.francoliptak.razasypelajes.R;

public abstract class RecognitionHandler {
    private AppCompatActivity context;

    public RecognitionHandler(AppCompatActivity context) {
        this.context = context;
    }
}
