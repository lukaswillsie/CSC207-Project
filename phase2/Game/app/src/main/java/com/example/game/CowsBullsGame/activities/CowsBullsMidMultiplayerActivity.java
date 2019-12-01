package com.example.game.CowsBullsGame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.data.MultiplayerGameData;
import com.example.game.data.Statistic;
import com.example.game.services.multiplayer_data.MultiplayerDataManagerFactory;
import com.example.game.services.stats.StatsManager;
import com.example.game.services.stats.StatsManagerBuilder;

import java.text.MessageFormat;

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

    Button nextTurnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls_mid_multiplayer);

        nextTurnButton = findViewById(R.id.nextTurn);
        nextTurnButton.setText(MessageFormat.format("{0}''s Turn",
                MultiplayerGameData.getPlayer2Username()));

        statsManager = new StatsManagerBuilder().build(this,
                MultiplayerGameData.getPlayer1Username());

        time = findViewById(R.id.time);
        time.setText(String.format("%s seconds", ((Integer) statsManager.getStat(Statistic.TIME_TAKEN)).toString()));


        numGuesses = findViewById(R.id.numGuesses);
        numGuesses.setText(String.format("%s", ((Integer) statsManager.getStat(Statistic.NUMBER_OF_GUESSES)).toString()));
    }

    public void nextTurn(View view) {
        Intent intent = new Intent(this, CowsBullsActivity.class);

        // Record that it is now player 2's turn
        new MultiplayerDataManagerFactory().build().setMultiplayerData(COWS_BULLS_PLAYER_TURN, 2);
        startActivity(intent);
    }

    /**
     * Method to specify what to do when android back button is pressed
     */
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
