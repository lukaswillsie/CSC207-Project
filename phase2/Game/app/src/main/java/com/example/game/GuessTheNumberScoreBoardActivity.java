package com.example.game;

import android.os.Bundle;
import android.widget.TextView;

import com.example.game.services.scoreboard.ScoreboardRepository;

public class GuessTheNumberScoreBoardActivity extends ScoreboardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(ScoreboardRepository.Game.GUESS_THE_NUMBER);

        String title = "Guess the Number Highscores";
        ((TextView) findViewById(R.id.highscoreTitle)).setText(title);
    }
}
