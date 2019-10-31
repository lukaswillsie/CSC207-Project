package com.example.game.services;

import com.example.game.data.Statistic;

public class UserStatsManager implements StatsManager {


    /**
     *
     * @param statistic - Statistic enum
     * @return - returns the value associated with the Statistic enum
     */
    @Override
    public int getStat(Statistic statistic) {
        return statistic.getValue();
    }

    @Override
    public void setStat(Statistic statistic, int value) {


    }
}
