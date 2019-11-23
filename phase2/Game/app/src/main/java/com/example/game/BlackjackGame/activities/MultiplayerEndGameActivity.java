package com.example.game.BlackjackGame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.BlackjackGame.services.MultiplayerEndGameActivityPresenter;
import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.services.MultiplayerDataManager;
import com.example.game.services.TestMultiplayerDataManager;

import java.text.DecimalFormat;

import static com.example.game.data.MultiplayerDoubleData.BLACKJACK_PLAYER_1_WIN_RATE;
import static com.example.game.data.MultiplayerDoubleData.BLACKJACK_PLAYER_2_WIN_RATE;
import static com.example.game.data.MultiplayerIntData.BLACKJACK_PLAYER1_LONGEST_STREAK;
import static com.example.game.data.MultiplayerIntData.BLACKJACK_PLAYER2_LONGEST_STREAK;

public class MultiplayerEndGameActivity extends AppCompatActivity {
    private MultiplayerEndGameActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_end_game);

        // TODO: Write an actual implementation of MDM and replace this dummy call
        presenter = new MultiplayerEndGameActivityPresenter(new TestMultiplayerDataManager());
        initializeTextViews();
    }

    public void mainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        presenter.resetMultiplayerData();
        startActivity(intent);
    }

    /**
     * Initialize the text views on the screen; populate the stats field with the players' stats,
     * and update the tags to show the players' username
     */
    public void initializeTextViews() {
        // TODO: Write an actual implementation and remove this dummy class
        MultiplayerDataManager manager = new TestMultiplayerDataManager();

        ((TextView) findViewById(R.id.blackjackMultiplayerEndTitle)).setText(R.string.blackjackMultiplayerEndTitle);
        double player1WinRate = manager.getMultiplayerData(BLACKJACK_PLAYER_1_WIN_RATE);
        double player2WinRate = manager.getMultiplayerData(BLACKJACK_PLAYER_2_WIN_RATE);
        int player1LongestStreak = manager.getMultiplayerData(BLACKJACK_PLAYER1_LONGEST_STREAK);
        int player2LongestStreak = manager.getMultiplayerData(BLACKJACK_PLAYER2_LONGEST_STREAK);

        String player1StatsLabel = manager.getPlayer1Username();
        String player1WinRateString = new DecimalFormat("##.##").format(manager.getMultiplayerData(BLACKJACK_PLAYER_1_WIN_RATE)) + "%";
        String player1LongestStreakString = "" + manager.getMultiplayerData(BLACKJACK_PLAYER1_LONGEST_STREAK);

        String player2StatsLabel = manager.getPlayer2Username();
        String player2WinRateString = new DecimalFormat("##.##").format(manager.getMultiplayerData(BLACKJACK_PLAYER_2_WIN_RATE)) + "%";
        String player2LongestStreakString = "" + manager.getMultiplayerData(BLACKJACK_PLAYER2_LONGEST_STREAK);

        ((TextView) findViewById(R.id.player1StatsLabel)).setText(player1StatsLabel);
        ((TextView) findViewById(R.id.player1WinRateDisplay)).setText(player1WinRateString);
        ((TextView) findViewById(R.id.player1LongestStreakDisplay)).setText(player1LongestStreakString);

        ((TextView) findViewById(R.id.player2StatsLabel)).setText(player2StatsLabel);
        ((TextView) findViewById(R.id.player2WinRateDisplay)).setText(player2WinRateString);
        ((TextView) findViewById(R.id.player2LongestStreakDisplay)).setText(player2LongestStreakString);

        TextView winLabel = findViewById(R.id.winLabel);
        String player1Win = "Player 1 Wins!";
        String player2Win = "Player 2 Wins!";
        String tie = "It's a tie!";
        if (player1WinRate > player2WinRate) {
            winLabel.setText(player1Win);
        } else if (player2WinRate > player1WinRate) {
            winLabel.setText(player2Win);
        } else {
            if (player1LongestStreak > player2LongestStreak) {
                winLabel.setText(player1Win);
            } else if (player2LongestStreak > player1LongestStreak) {
                winLabel.setText(player2Win);
            } else {
                winLabel.setText(tie);
            }
        }
    }
}
