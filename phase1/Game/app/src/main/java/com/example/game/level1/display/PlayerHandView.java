package com.example.game.level1.display;

import android.widget.TextView;

public class PlayerHandView {
    /**
     * The TextView this object will be updating
     */
    private TextView view;

    /**
     * Create a new PlayerHandView with the given TextView
     *
     * @param view - the TextView that this PlayerHandView will be updating
     */
    public PlayerHandView(TextView view) {
        this.view = view;
    }

    /**
     * Replace the text in this.view with newString
     *
     * @param newString - String to replace the TextView's current text with
     */
    void updateView(String newString) {
        this.view.setText(newString);
    }
}
