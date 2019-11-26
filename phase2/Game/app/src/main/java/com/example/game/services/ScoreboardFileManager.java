package com.example.game.services;

import android.util.Pair;

public class ScoreboardFileManager implements ScoreboardRepository {
    @Override
    public void addHighScore(String name, int score) {
        
    }

    @Override
    public Pair<String, Integer>[] getHighScores(int numberHighScores) {
        return new Pair[0];
    }
}
