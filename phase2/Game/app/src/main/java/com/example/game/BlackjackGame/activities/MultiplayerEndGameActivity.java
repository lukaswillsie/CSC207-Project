package com.example.game.BlackjackGame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    public void mainMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        presenter.resetMultiplayerData();
        startActivity(intent);
    }

    /**
     * Initialize the text views on the screen; populate the stats field with the players' stats,
     * and update the tags to show the players' username
     */
    public void initializeTextViews(){
        // TODO: Write an actual implementation and remove this dummy class
        MultiplayerDataManager manager = new TestMultiplayerDataManager();

        ((TextView)findViewById(R.id.blackjackMultiplayerEndTitle)).setText(R.string.blackjackMultiplayerEndTitle);

        String player1StatsLabel = manager.getPlayer1Username();
        String player1WinRate = new DecimalFormat("##.##").format(manager.getMultiplayerData(BLACKJACK_PLAYER_1_WIN_RATE)) + "%";
        String player1LongestStreak = "" + manager.getMultiplayerData(BLACKJACK_PLAYER1_LONGEST_STREAK);

        String player2StatsLabel = manager.getPlayer2Username();
        String player2WinRate = new DecimalFormat("##.##").format(manager.getMultiplayerData(BLACKJACK_PLAYER_2_WIN_RATE)) + "%";
        String player2LongestStreak = "" + manager.getMultiplayerData(BLACKJACK_PLAYER2_LONGEST_STREAK);

        ((TextView)findViewById(R.id.player1StatsLabel)).setText(player1StatsLabel);
        ((TextView)findViewById(R.id.player1WinRateDisplay)).setText(player1WinRate);
        ((TextView)findViewById(R.id.player1LongestStreakDisplay)).setText(player1LongestStreak);

        ((TextView)findViewById(R.id.player2StatsLabel)).setText(player2StatsLabel);
        ((TextView)findViewById(R.id.player2WinRateDisplay)).setText(player2WinRate);
        ((TextView)findViewById(R.id.player2LongestStreakDisplay)).setText(player2LongestStreak);
    }
}
