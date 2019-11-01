package com.example.game.services;

import com.example.game.data.Statistic;

/**
 * An interface that defines what a reasonable statistics manager should do: query a user's stats
 * and update a user's stats
 *
 * Implementing classes should provide a mechanism for determining what user's statistics are being
 * queried and updated
 */
public interface StatsManager {
    int getStat(Statistic statistic);

    void setStat(Statistic statistic, int value);
}
