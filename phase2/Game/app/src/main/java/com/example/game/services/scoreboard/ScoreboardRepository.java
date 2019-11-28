package com.example.game.services.scoreboard;

import android.util.Pair;

import java.util.List;

/**
 * A ScoreboardRepository provides two simple services: it allows high scores to be recorded
 * and accessed
 */
public interface ScoreboardRepository {
    enum Game {BLACKJACK, COWS_AND_BULLS, GUESS_THE_NUMBER}
    /**
     * Record that a player with given name has achieved the given score
     *
     * @param name         - the name of the player
     * @param score        - the player's score
     * @param callingClass - the class trying to update the high score
     */
    void addHighScore(String name, int score, ScoreboardUpdater callingClass);

    /**
     * Retrieves the *numberHighScores* highest scores, or all the high scores if there are fewer
     * than *numberHighScores* in total, and returns them as an array of pairs of the form
     * [name, score], in increasing order of score
     * <p>
     * Precondition: numberHighScores > 0
     *
     * @param numberHighScores - the number of highScores to fetch
     * @return the *numberHighScores* highest scores, in the form of a [name,score] tuple, or all
     * the high scores if numberHighScores exceeds the total
     */
    List<Pair<String, Integer>> getHighScores(int numberHighScores);
}
