package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.widget.TextView;

import com.example.game.data.Statistic;
import com.example.game.services.GameData;
import com.example.game.services.StatsManager;
import com.example.game.services.StatsManagerBuilder;

import java.text.NumberFormat;

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
        fewestGuesses.setText(String.valueOf(statsManager.getStat(Statistic.FEWEST_GUESSES)));

        quickestTime = findViewById(R.id.quickestTime);
        quickestTime.setText(String.valueOf(statsManager.getStat(Statistic.QUICKEST_TIME)));

        longestStreak = findViewById(R.id.longestStreak);
        longestStreak.setText(String.valueOf(statsManager.getStat(Statistic.LONGEST_STREAK)));


    }



}
