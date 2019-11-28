package com.example.game.GuessTheNumber.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.GuessTheNumber.domain.Game;
import com.example.game.GuessTheNumber.game_logic.GameManager;
import com.example.game.R;
import com.example.game.data.GameData;
import com.example.game.data.MultiplayerGameData;
import com.example.game.data.Setting;
import com.example.game.services.settings.SettingsManager;
import com.example.game.services.settings.SettingsManagerBuilder;

/**
 * The activity that appears right before the user is about to start a game of GuessTheNumber. This
 * activity is needed to resume the old game/read the rules/start a new game.
 */
public class GameStartActivity extends AppCompatActivity {
    public static GameManager gameManager = new GameManager();
    String username = GameData.USERNAME;
    boolean rulesAppear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);

        if (GameData.MULTIPLAYER && gameManager.getMultiplayerKeepPlaying()) {
            updateTurnText(MultiplayerGameData.getPlayer1Username());
            gameManager.resetGameManager();
            gameManager.setMultiplayerMode(true);
        }

        else if (GameData.MULTIPLAYER && !gameManager.getMultiplayerKeepPlaying()) {
            updateTurnText(MultiplayerGameData.getPlayer2Username());
            gameManager.startNewGame();
            gameManager.setMultiplayerMode(true);
        }
        else {
            gameManager.setMultiplayerMode(false);
        }
        this.displayResumeButton();
        this.setNumRounds();
    }

    /**
     * When a user clicks the start button, the GuessTheNumberPlayActivity activity appears and the user
     * proceeds to start a new game of GuessTheNumber
     */
    public void startTheGame(View view) {
        gameManager.resetCurrentRounds();
        gameManager.startNewGame();
        Intent intent = new Intent(this, GuessTheNumberPlayActivity.class);
        startActivity(intent);
    }

    /**
     * When a user clicks on the resume button, the GameActivity1 activity appears with the stats of
     * the game that the user has previously paused on.
     */
    public void resumeGame(View view) {
        Intent intent = new Intent(this, GuessTheNumberPlayActivity.class);
        startActivity(intent);
    }

    /**
     * The user can click the rules button to view the rules of GuessTheNumber, or click it again to
     * hide the rules of the game.
     */
    public void rules(View view) {
        TextView rulesText = findViewById(R.id.rulesText);
        if (!rulesAppear) {
            rulesText.setVisibility(View.VISIBLE);
            rulesAppear = true;
        } else {
            rulesText.setVisibility(View.INVISIBLE);
            rulesAppear = false;
        }
    }

    /**
     * Check if the appearance of resume button is needed. Resume button appears iff the is a game
     * which is not finished or a user has already played at least one round but hasn't finished
     * all the rounds.
     */
    private void displayResumeButton() {
        Button btn = findViewById(R.id.resumeGame);
        Game game = gameManager.getCurrentGame();
        if (game.isFinished() || (game.getPoints() == 0 && gameManager.getCurrentRound() == 0)) {
            btn.setVisibility(View.INVISIBLE);
        } else {
            btn.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Set the number of rounds user wants to play based on customized settings.
     */
    private void setNumRounds() {
        SettingsManager manager = new SettingsManagerBuilder().build(this, username);
        gameManager.setRoundsToPlay(manager.getSetting(Setting.NUM_ROUNDS));
    }

    private void updateTurnText(String player) {
        String turnText;

        turnText = "It is " + player + "'s turn.";

        ((TextView) findViewById(R.id.turnText)).setText(turnText);
    }

}
