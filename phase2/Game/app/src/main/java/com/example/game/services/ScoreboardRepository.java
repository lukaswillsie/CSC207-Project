package com.example.game.services;

import android.util.Pair;

/**
 * A ScoreboardRepository provides two simple services: it allows high scores to be recorded
 * and accessed
 */
public interface ScoreboardRepository {
    /**
     * Record that a player with given name has achieved the given score
     * @param name - the name of the player
     * @param score - the player's score
     */
    void addHighScore(String name, int score);

    /**
     * Retrieves the *numberHighScores* highest scores, or all the high scores if there are fewer
     * than *numberHighScores* in total, and returns them as an array of pairs of the form
     * [name, score], in increasing order of score
     *
     * Precondition: numberHighScores > 0
     * @param numberHighScores - the number of highScores to fetch
     * @return the *numberHighScores* highest scores, or all the high scores if numberHighScores
     * exceeds the total
     */
    Pair<String, Integer>[] getHighScores(int numberHighScores);
}
