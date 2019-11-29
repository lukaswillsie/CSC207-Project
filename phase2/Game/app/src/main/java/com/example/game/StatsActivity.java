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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        String username = GameData.USERNAME;
        StatsManager statsManager = new StatsManagerBuilder().build(this, username);

        TextView fewestGuesses = findViewById(R.id.fewestGuess);
        String fewestGuessesDisplay = statsManager.getStat(Statistic.FEWEST_GUESSES) + " " +
                statsManager.getStat(Statistic.SECOND_FEWEST_GUESSES) + " " +
                statsManager.getStat(Statistic.THIRD_FEWEST_GUESSES);
        
        fewestGuesses.setText(fewestGuessesDisplay);

        TextView quickestTime = findViewById(R.id.quickestTime);
        String quickTime = statsManager.getStat(Statistic.QUICKEST_TIME) + "s";
        quickestTime.setText(quickTime);

        TextView longestStreak = findViewById(R.id.longestStreak);
        longestStreak.setText(String.valueOf(statsManager.getStat(Statistic.LONGEST_STREAK)));
    }
}
