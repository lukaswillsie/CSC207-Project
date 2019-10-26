package com.example.game.level1;

import android.widget.TextView;

public class PlayerHandView {
    private TextView view;

    public PlayerHandView(TextView view){
        this.view = view;
    }

    public void updateView(String newString){
        this.view.setText(newString);
    }
}
