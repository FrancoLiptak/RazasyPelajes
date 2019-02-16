package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class Level {
    private Integer id;
    private View view;

    public abstract boolean playLevelAndReportSuccessOrNot(AppCompatActivity gameActivity);
}
