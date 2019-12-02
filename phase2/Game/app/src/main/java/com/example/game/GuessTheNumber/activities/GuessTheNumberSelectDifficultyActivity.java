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

    }

    public void backClick(View view) {
        Intent intent = new Intent(this, GameStartActivity.class);
        startActivity(intent);
    }
}
