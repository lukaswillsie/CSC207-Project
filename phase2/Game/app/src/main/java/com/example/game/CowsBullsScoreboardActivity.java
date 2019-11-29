package com.example.game;

import android.os.Bundle;
import android.widget.TextView;

import com.example.game.services.scoreboard.ScoreboardRepository;
import com.example.game.services.scoreboard.ScoreboardRepositoryFactory;

public class CowsBullsScoreboardActivity extends ScoreboardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScoreboardRepository scoreboardRepository = new ScoreboardRepositoryFactory().build(ScoreboardRepository.Game.COWS_AND_BULLS);

        initialize(scoreboardRepository.getHighScores(20), "No scores to show");

        String title = "Cows and Bulls Highscores";
        ((TextView) findViewById(R.id.highscoreTitle)).setText(title);
    }
}
