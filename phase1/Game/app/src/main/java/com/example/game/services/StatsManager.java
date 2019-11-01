package com.example.game.services;

import com.example.game.data.Statistic;

public interface StatsManager {
    int getStat(Statistic statistic);

    void setStat(Statistic statistic, int value);
}
