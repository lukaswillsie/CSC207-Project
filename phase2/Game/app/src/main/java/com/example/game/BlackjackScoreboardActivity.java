package com.example.game;

import android.os.Bundle;

import com.example.game.services.scoreboard.ScoreboardRepository;

public class BlackjackScoreboardActivity extends ScoreboardActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initialize(ScoreboardRepository.Game.BLACKJACK);
    }
}
