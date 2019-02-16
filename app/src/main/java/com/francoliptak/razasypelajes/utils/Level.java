package com.francoliptak.razasypelajes.utils;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.francoliptak.razasypelajes.GameActivity;

public abstract class Level implements Comparable<Level> {
    private Integer id;
    private View view;

    public abstract void playLevel(GameActivity gameActivity);

    public abstract void evaluateOptionChosen(View view, GameActivity gameActivity);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public int compareTo(Level anotherLevel) {
        if (this.getId() > anotherLevel.getId()) return 1;
        if (this.getId() < anotherLevel.getId()) return -1;
        return 0;
    }
}
