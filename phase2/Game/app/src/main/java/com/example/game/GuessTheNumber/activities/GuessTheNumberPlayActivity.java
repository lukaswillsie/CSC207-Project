package com.example.game.GuessTheNumber.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.GuessTheNumber.domain.Game;
import com.example.game.GuessTheNumber.game_logic.GameManager;
import com.example.game.MainActivity;
import com.example.game.R;

/**
 * This page displayed when user is actually playing a game.
 */
public class GuessTheNumberPlayActivity extends AppCompatActivity {
    GameManager gameManager = GameStartActivity.gameManager;
    static int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gtnum__play_activity);
        this.updateScore();
        ImageView eeyore = findViewById(R.id.highlowimage);
        eeyore.setVisibility(View.INVISIBLE);
        updateExitText();
    }

    /**
     * Assuming that a user inserted a number; this method gets the input.
     */
    private int getGuess() {
        return Integer.valueOf(((TextView) findViewById(R.id.guessInput)).getText().toString());
    }

    /**
     * Based on the user's guess, we display respective page/text and update some statistics.
     */
    public void submitGuess(View view) {
        try {
            guess = getGuess();
            Game currentGame = gameManager.getCurrentGame();
            ((TextView) findViewById(R.id.guessInput)).setText("");

            if (currentGame.checkTheRightGuess(guess)) {
                currentGame.finishTheGame(guess);
                this.finishTheRound();
            } else {
                if (currentGame.checkGuess(guess)) {
                    this.highGuess();
                } else {
                    this.lowGuess();
                }
                ImageView eeyore = findViewById(R.id.highlowimage);
                eeyore.setVisibility(View.VISIBLE);
                this.updateScore();
            }
        } catch (Exception e) {
            this.BadNumber();
        }
    }

    /**
     * Allows user to pause the game, save it and exit to the MainActivity.
     */
    public void pauseExit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        if (gameManager.getMultiplayerMode()) {
            gameManager.resetGameManager();
        }
    }

    /**
     * Display the text if the user's guess is too high.
     */
    private void highGuess() {
        ((TextView) findViewById(R.id.textView)).setText("Your guess is too high, try again.");
    }

    /**
     * Display the text if the user's guess is too low.
     */
    private void lowGuess() {
        ((TextView) findViewById(R.id.textView)).setText("Your guess is too low, try again.");
    }

    /**
     * Displays the text if the user's input is null.
     */
    private void BadNumber() {
        ((TextView) findViewById(R.id.textView)).setText("You need to insert a number, please try again");
    }

    /**
     * Updates the display of the #points and #guesses.
     */
    private void updateScore() {
        Game currentGame = gameManager.getCurrentGame();
        ((TextView) findViewById(R.id.pointsFinishId)).setText(String.valueOf(currentGame.getPoints()));
        ((TextView) findViewById(R.id.guessesId)).setText(String.valueOf(currentGame.getNumOfGuess()));
    }

    /**
     * Finish the current round, refer user to GameFinishActivity.
     */
    private void finishTheRound() {
        gameManager.checkRounds();
        Intent intent = new Intent(this, GameFinishActivity.class);
        startActivity(intent);
    }

    private void updateExitText() {
        String exitText;

        if (gameManager.getMultiplayerMode()) {
            exitText = "Exit game";
        }

        else {
            exitText = "Pause and exit";
        }

        ((TextView) findViewById(R.id.pauseExit)).setText(exitText);
    }

    /**
     * Prevents the user from being able to return to the game screen by pressing the back button
     */
    @Override
    public void onBackPressed() {
    }
}
