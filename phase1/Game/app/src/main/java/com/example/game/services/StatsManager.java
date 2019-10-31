package com.example.game.services;

import com.example.game.data.Statistic;

public interface StatsManager {
    public int getStat(Statistic statistic);
    public void setStat(Statistic statistic, int value);
}
