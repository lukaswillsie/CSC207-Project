package com.example.game.level2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.data.Setting;
import com.example.game.services.GameData;
import com.example.game.services.SettingsManager;
import com.example.game.services.SettingsManagerBuilder;

/**
 * The activity that appears right before the user is about to start a game of GuessTheNumber.
 */
public class GameStartActivity extends AppCompatActivity {
    public static GameManager gameManager = new GameManager();
    String username = GameData.USERNAME;
    boolean rulesAppear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);
        Button btn = findViewById(R.id.resumeGame);
        Game game = gameManager.getCurrentGame();
        if ((game.isFinished() || game.getPoints() == 0) && gameManager.getCurrentRound() != 1) {
            if (!gameManager.getKeepPlaying() || game.getPoints() == 0) {
                btn.setVisibility(View.INVISIBLE);
            } else {
                btn.setVisibility(View.VISIBLE);
            }
            SettingsManager manager = new SettingsManagerBuilder().build(this, username);
            gameManager.setRoundsToPlay(manager.getSetting(Setting.NUM_ROUNDS));

        }
    }
    /**
     * When a user clicks the start button, the GameStartActivity1 activity appears and the user
     * proceeds to start a new game of GuessTheNumber
     */
    public void startTheGame(View view) {
        gameManager.resetCurrentRounds();
        gameManager.startNewGame();
        Intent intent = new Intent(this, GameStartActivity1.class);
        startActivity(intent);
    }

    /**
     * When a user clicks on the resume button, the GameActivity1 activity appears with the stats of
     * the game that the user has previously paused on.
     */
    public void resumeGame(View view) {
        Intent intent = new Intent(this, GameStartActivity1.class);
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


}
