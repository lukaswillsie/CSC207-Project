package com.example.game;

import android.os.Bundle;
import android.widget.TextView;

import com.example.game.services.scoreboard.ScoreboardRepository;

public class CowsBullsScoreboardActivity extends ScoreboardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(ScoreboardRepository.Game.COWS_AND_BULLS);

        String title = "Cows and Bulls Highscores";
        ((TextView) findViewById(R.id.highscoreTitle)).setText(title);
    }
}
