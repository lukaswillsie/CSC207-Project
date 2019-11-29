package com.example.game;

import android.os.Bundle;
import android.widget.TextView;

import com.example.game.services.scoreboard.ScoreboardRepository;

public class BlackjackScoreboardActivity extends ScoreboardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(ScoreboardRepository.Game.BLACKJACK);

        String title = "Blackjack Highscores";
        ((TextView) findViewById(R.id.highscoreTitle)).setText(title);
    }
}
