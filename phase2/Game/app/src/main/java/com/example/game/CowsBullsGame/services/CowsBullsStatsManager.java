package com.example.game.CowsBullsGame.services;

import com.example.game.data.Statistic;
import com.example.game.services.StatsManager;

public class CowsBullsStatsManager {

    //UserStatsManager for this game
    private StatsManager statsManager;

    /**
     * Thus constructor call for the CowsBullsStatManager Class
     * @param statsManager The statsManager for this game
     */
    public CowsBullsStatsManager(StatsManager statsManager){

        this.statsManager = statsManager;

    }

    /**
     * Updates the users stats given the time <seconds> and the number of guesses <numberOfGuesses>
     * the user took this round
     *
     * @param seconds - time take for user to guess correctly
     * @param numberOfGuesses - number of guess takes for user to guess correctly
     */
    public void update(int seconds, int numberOfGuesses){

        statsManager.setStat(Statistic.TIME_TAKEN, seconds);
        int minTime = statsManager.getStat(Statistic.QUICKEST_TIME);
        if (seconds < minTime || minTime == 0) {
            statsManager.setStat(Statistic.QUICKEST_TIME, seconds);
        }
        statsManager.setStat(Statistic.NUMBER_OF_GUESSES, numberOfGuesses);

    }
}

