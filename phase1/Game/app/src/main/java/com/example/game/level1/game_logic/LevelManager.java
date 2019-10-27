package com.example.game.level1.game_logic;

import android.view.View;

import com.example.game.level1.activities.BlackjackPlayActivity;

public abstract class LevelManager {
    BlackjackPlayActivity activity;

    public abstract void setup();

    public abstract void play();

    public abstract void userButtonClick(View view);

    public void setActivity(BlackjackPlayActivity activity) {
        this.activity = activity;
    }
}
