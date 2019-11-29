package com.example.game.BlackjackGame.services;

import android.util.Pair;

import com.example.game.services.scoreboard.ScoreboardRepository;
import com.example.game.services.scoreboard.ScoreboardRepositoryFactory;

import java.util.List;

/**
 * A presenter class for BlackjackPlayActivity that encapsulates use cases such as whether or not
 * a user should be asked to save a certain score
 */
public class BlackjackPlayActivityPresenter {
    /**
     * Returns whether or not the user should be prompted to save the given score, i.e. if it's high
     * enough to justify doing so
     *
     * @param score - the score to check
     * @return whether or not the game should prompt the user to save the given score
     */
    public boolean shouldPrompt(int score){
        ScoreboardRepository highscoreManager = new ScoreboardRepositoryFactory().build(ScoreboardRepository.Game.BLACKJACK);

        // If the given score would be in the top 10, return true
        // Otherwise it won't be displayed on the scoreboard screen, so return false
        List<Pair<String, Integer>> highestScores = highscoreManager.getHighScores(10);

        if(highestScores.size() < 10){
            return true;
        }

        int counter = 0;
        for(Pair<String, Integer> pair : highestScores){
            if(pair.second >= score){
                counter++;
            }
            else {
                return true;
            }

            if(counter == 10){
                return false;
            }
        }

        // If we've gone through all 10 highscores and they've all been >= score, return false
        return false;
    }
}
