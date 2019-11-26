package com.example.game.BlackjackGame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;
import com.example.game.services.MultiplayerDataManager;
import com.example.game.services.MultiplayerDataManagerFactory;
import com.example.game.services.TestMultiplayerDataManager;

import java.text.DecimalFormat;

import static com.example.game.data.MultiplayerDoubleData.BLACKJACK_PLAYER_1_WIN_RATE;
import static com.example.game.data.MultiplayerIntData.BLACKJACK_PLAYER1_LONGEST_STREAK;
import static com.example.game.data.MultiplayerIntData.BLACKJACK_PLAYER_TURN;

public class BlackjackMidMultiplayerActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_multiplayer);

        initializeTextViews();
    }

    public void player2Turn(View view) {
        Intent intent = new Intent(this, BlackjackPlayActivity.class);

        // Record that it is now player 2's turn
        new MultiplayerDataManagerFactory().build().setMultiplayerData(BLACKJACK_PLAYER_TURN, 2);
        startActivity(intent);
    }

    /**
     * Initialize the title text view to say "*Player 1 name*'s statistics", and the stats display
     * text views to display player 1's statistics
     */
    private void initializeTextViews() {
        MultiplayerDataManager manager = new MultiplayerDataManagerFactory().build();
        String player1WinRate = new DecimalFormat("##.##").format(manager.getMultiplayerData(BLACKJACK_PLAYER_1_WIN_RATE)) + "%";
        String player1LongestStreak = "" + manager.getMultiplayerData(BLACKJACK_PLAYER1_LONGEST_STREAK);
        String title = manager.getPlayer1Username() + "'s Statistics";

        ((TextView) findViewById(R.id.longestStreakDisplay)).setText(player1LongestStreak);
        ((TextView) findViewById(R.id.winRateDisplay)).setText(player1WinRate);
        ((TextView) findViewById(R.id.blackjackMidMultiplayerTitle)).setText(title);
    }
}
