package com.example.game.services.scoreboard;

/**
 * Classes must implement this interface to use ScoreboardRepository objects to update highscores
 */
public interface ScoreboardUpdater {
    /**
     * Notifies the object that a highscore could not be added
     */
    void scoreboardStoreError();
}
