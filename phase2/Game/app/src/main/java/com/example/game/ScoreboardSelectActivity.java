package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ScoreboardSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard_select);
    }

    public void cowsAndBullsScoreboard(View view){
        Intent intent = new Intent(this, CowsBullsScoreboardActivity.class);
        startActivity(intent);
    }

    public void blackjackScoreboard(View view){
        Intent intent = new Intent(this, BlackjackScoreboardActivity.class);
        startActivity(intent);
    }

    public void guessTheNumberScoreboard(View view){
        Intent intent = new Intent(this, GuessTheNumberScoreBoardActivity.class);
        startActivity(intent);
    }
}
