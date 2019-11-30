package com.example.game;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.game.services.scoreboard.ScoreboardRepository;
import com.example.game.services.scoreboard.ScoreboardRepositoryFactory;

public class BlackjackScoreboardActivity extends ScoreboardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScoreboardRepository scoreboardRepository = new ScoreboardRepositoryFactory().build(ScoreboardRepository.Game.BLACKJACK);

        initialize(scoreboardRepository.getHighScores(), "No scores to show");
        Log.i("blah", scoreboardRepository.getHighScores().toString() + scoreboardRepository.getHighScores().size());

        String title = "Blackjack Highscores";
        ((TextView) findViewById(R.id.highscoreTitle)).setText(title);
    }
}
