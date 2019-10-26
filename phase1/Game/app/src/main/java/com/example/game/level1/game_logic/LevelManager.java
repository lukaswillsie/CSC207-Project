package com.example.game.level1.game_logic;

import android.app.Activity;
import android.view.View;

public abstract class LevelManager {
    Activity activity;
    public abstract void setup();

    public abstract void play();

    public abstract void userButtonClick(View view);

    public void setActivity(Activity activity){
        this.activity = activity;
    }
}
