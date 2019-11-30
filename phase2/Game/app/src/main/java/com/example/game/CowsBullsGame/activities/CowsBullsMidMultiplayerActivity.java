package com.example.game.CowsBullsGame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.BlackjackGame.activities.BlackjackPlayActivity;
import com.example.game.R;
import com.example.game.data.GameData;
import com.example.game.data.MultiplayerGameData;
import com.example.game.data.Statistic;
import com.example.game.services.multiplayer_data.MultiplayerDataManager;
import com.example.game.services.multiplayer_data.MultiplayerDataManagerFactory;
import com.example.game.services.stats.StatsManager;
import com.example.game.services.stats.StatsManagerBuilder;

import static com.example.game.data.MultiplayerIntData.BLACKJACK_PLAYER_TURN;
import static com.example.game.data.MultiplayerIntData.COWS_BULLS_PLAYER_TURN;

public class CowsBullsMidMultiplayerActivity extends AppCompatActivity {

    /**
     * TextView display for user's time taken to guess the number
     */
    TextView time;

    /**
     * TextView display for user's number of guesses taken to guess the number
     */
    TextView numGuesses;

    /**
     * StatsManager object to retrieve and set stats for user
     */
    StatsManager statsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls_mid_multiplayer);

        statsManager = new StatsManagerBuilder().build(this, MultiplayerGameData.getPlayer1Username());

        time = findViewById(R.id.time);
        time.setText(((Integer) statsManager.getStat(Statistic.TIME_TAKEN)).toString() + " seconds");



        numGuesses = findViewById(R.id.numGuesses);
        numGuesses.setText(((Integer) statsManager.getStat(Statistic.NUMBER_OF_GUESSES)).toString());
    }

    public void nextTurn(View view) {
        Intent intent = new Intent(this, CowsBullsActivity.class);

        // Record that it is now player 2's turn
        new MultiplayerDataManagerFactory().build().setMultiplayerData(COWS_BULLS_PLAYER_TURN, 2);
        startActivity(intent);
    }
}
