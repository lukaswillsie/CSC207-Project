package com.example.game.BlackjackGame.services;

import android.content.Context;

import com.example.game.data.Statistic;
import com.example.game.services.GameData;
import com.example.game.services.StatsManager;
import com.example.game.services.StatsManagerBuilder;

public class StatsRecorder {
    /**
     * Keeps track of the player's longest win streak since this object was created
     */
    private int longestStreak = 0;

    /**
     * Keeps track of the length of the player's current win streak
     */
    private int currentStreak = 0;

    /**
     * How many times the player has won since this object was created
     */
    private int wins;

    /**
     * How many rounds this player has played since this object was created
     */
    private int roundsPlayed;

    /**
     * The player's all time longest winning streak at the moment this object was created
     */
    private final int allTimeLongestStreak;

    /**
     * A StatsManager for accessing and potentially updating the player's longestStreak statistic
     */
    private StatsManager statsManager;

    /**
     * Create a new StatsRecord from the specified context
     */
    public StatsRecorder(Context context){
        statsManager = new StatsManagerBuilder().build(context, GameData.USERNAME);
        allTimeLongestStreak = statsManager.getStat(Statistic.LONGEST_STREAK);
    }

    /**
     * Record that the player won a round
     */
    public void playerWin(){
        wins++;
        roundsPlayed++;

        currentStreak++;
        if(currentStreak > longestStreak){
            longestStreak = currentStreak;
        }
    }

    /**
     * Record that the player lost a round
     */
    public void playerLose(){
        roundsPlayed++;
        currentStreak = 0;
    }

    /**
     * Call this method when you want to check if the player has broken their record,
     * and if so you want the data associated with their account to be updated
     */
    public void update(){
        if(longestStreak > allTimeLongestStreak){
            statsManager.setStat(Statistic.LONGEST_STREAK, longestStreak);
        }
    }

    /**
     * Calculate the player's win rate according to this StatRecorder's data
     * @return the player's win rate if roundsPlayed > 0, -1 otherwise
     */
    public double getWinRate(){
        if(roundsPlayed > 0){
            return (double)wins / roundsPlayed;
        }

        return -1;
    }

    /**
     * Return the player's longest winning streak since this object was created
     * @return - the player's longest winning streak since this object was created
     */
    public int getLongestStreak(){
        return longestStreak;
    }
}
