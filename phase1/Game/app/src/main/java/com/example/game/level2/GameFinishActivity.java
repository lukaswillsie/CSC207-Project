package com.example.game.level2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.MainActivity;
import com.example.game.R;

/**
 * This activity appears when the user successfully finishes each round of GuessTheNumber.
 */
public class GameFinishActivity extends AppCompatActivity {
    GameManager gameManager = GameStartActivity.gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_finish_activity);
        Game currentGame = gameManager.getCurrentGame();
        currentGame.setIsFinished();
        ((TextView) findViewById(R.id.points16)).setText(String.valueOf(currentGame.getPoints()));
        ((TextView) findViewById(R.id.finalGuesses)).setText(String.valueOf(currentGame.getNumOfGuess()));
        ((TextView) findViewById(R.id.currentRoundText)).setText(String.valueOf(gameManager.getCurrentRound()));
        ((TextView) findViewById(R.id.totalRoundsText)).setText(String.valueOf(gameManager.getRoundsToPlay()));

        if (gameManager.getKeepPlaying()) {
            findViewById(R.id.mainMenuButton).setVisibility(View.INVISIBLE);
            findViewById(R.id.playAgainButton).setVisibility(View.INVISIBLE);
            findViewById(R.id.nextRoundButton).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.mainMenuButton).setVisibility(View.VISIBLE);
            findViewById(R.id.playAgainButton).setVisibility(View.VISIBLE);
            findViewById(R.id.nextRoundButton).setVisibility(View.INVISIBLE);
            gameManager.resetCurrentRounds();
        }
    }

    /**
     * When the main menu button is clicked, the user is taken to the MainActivity activity.
     */
    public void mainMenuClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * When the playAgain button is clicked, the user is taken to the GameStartActivity1 activity
     * which will allow them to play GuessTheNumber again.
     */
    public void playAgainClick(View view) {
        Intent intent = new Intent(this, GameStartActivity1.class);
        gameManager.startNewGame();
        startActivity(intent);
    }

    /**
     * When nextRound button is clicked, the user proceeds to go onto the next round of
     * GuessTheNumber.
     */
    public void nextRound(View view) {
        Intent intent = new Intent(this, GameStartActivity1.class);
        gameManager.startNewGame();
        startActivity(intent);
    }

}
