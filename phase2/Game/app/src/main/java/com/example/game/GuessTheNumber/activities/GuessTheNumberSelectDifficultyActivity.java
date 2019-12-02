package com.example.game.GuessTheNumber.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.R;

public class GuessTheNumberSelectDifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_number_select_difficulty);
    }

    public void easyDifficultyClick(View view) {

    }

    public void mediumDifficultyClick(View view) {

    }

    public void insaneDifficultyClick(View view) {
<<<<<<< HEAD
        settingsManager.updateSetting(Setting.GUESS_THE_NUMBER_RANGE, 1000);
        currDiff.setText("Insane");
=======

>>>>>>> afea3c1d914c544864c9e4abe4ea67c32b2989cd
    }

    public void backClick(View view) {
        Intent intent = new Intent(this, GameStartActivity.class);
        startActivity(intent);
    }
}
