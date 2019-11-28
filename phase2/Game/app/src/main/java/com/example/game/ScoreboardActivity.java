package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public abstract class ScoreboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
    }
}
