package com.example.game.CowsBullsGame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.data.MultiplayerGameData;
import com.example.game.data.MultiplayerIntData;
import com.example.game.services.multiplayer_data.MultiplayerDataManager;
import com.example.game.services.multiplayer_data.MultiplayerDataManagerFactory;
import com.example.game.services.stats.StatsManager;

public class CowsBullsMutliplayerFinishActivity extends AppCompatActivity {

    /**
     * TextView display for player 1's time taken to guess the number
     */
    private TextView player1TimeTaken;

    /**
     * TextView display for player 1's number of guesses taken to guess the number
     */
    private TextView player1TurnsTaken;

    /**
     * TextView display for player 2's time taken to guess the number
     */
    private TextView player2TimeTaken;

    /**
     * TextView display for player 2's number of guesses taken to guess the number
     */
    private TextView player2TurnsTaken;

    /**
     * TextView display for player 2's number of guesses taken to guess the number
     */
    private TextView winMessage;


    /**
     * MultiplayerDataManager object to retrieve and set stats for user
     */
    private MultiplayerDataManager multiplayerDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls_mutliplayer_finish);

        multiplayerDataManager = new MultiplayerDataManagerFactory().build();

        String player1Username = MultiplayerGameData.getPlayer1Username();
        String player2Username = MultiplayerGameData.getPlayer2Username();

        winMessage = findViewById(R.id.winMessage);
        player1TimeTaken = findViewById(R.id.player1TimeTaken);
        player2TimeTaken = findViewById(R.id.player2TimeTaken);
        player1TurnsTaken = findViewById(R.id.player1TurnsTaken);
        player2TurnsTaken = findViewById(R.id.player2TurnsTaken);

        int player1Time = multiplayerDataManager.getMultiplayerData(MultiplayerIntData.COWS_BULLS_PLAYER_1_TIME_TAKEN);
        int player2Time = multiplayerDataManager.getMultiplayerData(MultiplayerIntData.COWS_BULLS_PLAYER_2_TIME_TAKEN);
        int player1Turns = multiplayerDataManager.getMultiplayerData(MultiplayerIntData.COWS_BULLS_PLAYER_1_NUMBER_OF_GUESSES);
        int player2Turns = multiplayerDataManager.getMultiplayerData(MultiplayerIntData.COWS_BULLS_PLAYER_2_NUMBER_OF_GUESSES);

        player1TimeTaken.setText(player1Time);
        player2TimeTaken.setText(player2Time);
        player1TurnsTaken.setText(player1Turns);
        player2TurnsTaken.setText(player2Turns);

        if (player1Time == player2Time & player1Turns == player2Turns){
            winMessage.setText("");
        }else if (player1Time >= player2Time & player1Turns >= player2Turns){

        }else if (player1Time <= player2Time & player1Turns <= player2Turns){

        }else if (player1Time >= player2Time & player1Turns <= player2Turns){

        }else {

        }
    }

    public void menu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void playAgain(View view) {
        Intent intent = new Intent(this, CowsBullsStartActivity.class);
        startActivity(intent);
    }
}
