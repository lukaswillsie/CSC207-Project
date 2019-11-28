package com.example.game;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.data.GameData;
import com.example.game.data.Statistic;
import com.example.game.services.stats.StatsManager;
import com.example.game.services.stats.StatsManagerBuilder;

/**
 * The page displayed when the user is viewing their stats
 */
public class StatsActivity extends AppCompatActivity {
    private StatsManager statsManager;
    private String username;
    private TextView fewestGuesses;
    private TextView quickestTime;
    private TextView longestStreak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        username = GameData.USERNAME;
        statsManager = new StatsManagerBuilder().build(this, username);

        fewestGuesses = findViewById(R.id.fewestGuess);
        fewestGuesses.setText(String.valueOf(statsManager.getStat(Statistic.FEWEST_GUESSES)) + " " +
                String.valueOf(statsManager.getStat(Statistic.SECOND_FEWEST_GUESSES)) + " " +
                String.valueOf(statsManager.getStat(Statistic.THIRD_FEWEST_GUESSES)));

        quickestTime = findViewById(R.id.quickestTime);
        String quickTime = statsManager.getStat(Statistic.QUICKEST_TIME) + "s";
        quickestTime.setText(quickTime);

        longestStreak = findViewById(R.id.longestStreak);
        longestStreak.setText(String.valueOf(statsManager.getStat(Statistic.LONGEST_STREAK)));
    }
}
