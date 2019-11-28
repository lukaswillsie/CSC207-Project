package com.example.game.GuessTheNumber.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.GuessTheNumber.domain.Game;
import com.example.game.GuessTheNumber.game_logic.GameManager;
import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.data.GameData;
import com.example.game.data.Statistic;
import com.example.game.services.stats.StatsManager;
import com.example.game.services.stats.StatsManagerBuilder;

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
        this.updateStatistics();
        ((TextView) findViewById(R.id.points16)).setText(String.valueOf(currentGame.getPoints()));
        ((TextView) findViewById(R.id.finalGuesses)).setText(String.valueOf(currentGame.getNumOfGuess()));
        ((TextView) findViewById(R.id.currentRoundText)).setText(String.valueOf(gameManager.getCurrentRound()));
        ((TextView) findViewById(R.id.totalRoundsText)).setText(String.valueOf(gameManager.getRoundsToPlay()));

        if (gameManager.getKeepPlaying()) {
            this.inverseVisibility();
            hideNextPlayerButton();

        } else {
            gameManager.changeMultiplayerKeepPlaying();

            // there is still next player
            if (gameManager.getMultiplayerMode() && !gameManager.getMultiplayerKeepPlaying()) {
                showNextPlayerButton();
                hideAllButtons();
            }

            // multiplayer game ends
            else if (gameManager.getMultiplayerMode() && gameManager.getMultiplayerKeepPlaying()){
                hideNextPlayerButton();
                findViewById(R.id.nextRoundButton).setVisibility(View.INVISIBLE);
                findViewById(R.id.playAgainButton).setVisibility(View.INVISIBLE);
                findViewById(R.id.mainMenuButton).setVisibility(View.VISIBLE);
            }

            // not multiplayer and game ends
            else {
                this.reverseVisibility();
                hideNextPlayerButton();
            }
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
     * When the playAgain button is clicked, the user is taken to the GuessTheNumberPlayActivity activity
     * which will allow them to play GuessTheNumber again.
     */
    public void playAgainClick(View view) {
        Intent intent = new Intent(this, GuessTheNumberPlayActivity.class);
        gameManager.startNewGame();
        startActivity(intent);
    }

    public void nextPlayerClick(View view) {
        Intent intent = new Intent(this, GameStartActivity.class);
        gameManager.startNewGame();
        startActivity(intent);
    }

    /**
     * When nextRound button is clicked, the user proceeds to go onto the next round of
     * GuessTheNumber.
     */
    public void nextRound(View view) {
        Intent intent = new Intent(this, GuessTheNumberPlayActivity.class);
        gameManager.startNewGame();
        startActivity(intent);
    }

    /**
     * Shows the user the buttons that she/he is allowed to click when there is at least one round
     * left to play.
     */
    public void inverseVisibility() {
        findViewById(R.id.mainMenuButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.playAgainButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.nextRoundButton).setVisibility(View.VISIBLE);
    }

    /**
     * Shows user the buttons that he/she is allowed to click when the all the rounds are finished.
     */
    public void reverseVisibility() {
        findViewById(R.id.mainMenuButton).setVisibility(View.VISIBLE);
        findViewById(R.id.playAgainButton).setVisibility(View.VISIBLE);
        findViewById(R.id.nextRoundButton).setVisibility(View.INVISIBLE);
    }

    public void showNextPlayerButton() {
        findViewById(R.id.nextPlayer).setVisibility(View.VISIBLE);
    }

    public void hideNextPlayerButton() {
        findViewById(R.id.nextPlayer).setVisibility(View.INVISIBLE);
    }

    public void hideAllButtons() {
        findViewById(R.id.mainMenuButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.playAgainButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.nextRoundButton).setVisibility(View.INVISIBLE);
    }

    /**
     * Updates statistics in the game. If the user made the new record(guessed the number with fewest
     * guess, we update their statistics.
     */
    public void updateStatistics() {
        String username = GameData.USERNAME;

        StatsManager statsManager = new StatsManagerBuilder().build(this, username);
        int guesses = gameManager.getCurrentGame().getNumOfGuess();

        int firstBest = statsManager.getStat(Statistic.FEWEST_GUESSES);
        int secondBest = statsManager.getStat(Statistic.SECOND_FEWEST_GUESSES);
        int thirdBest = statsManager.getStat(Statistic.THIRD_FEWEST_GUESSES);

        if (gameManager.getCurrentGame().getNumOfGuess() >= thirdBest) {
            return;
        }

        else {
            if (guesses < firstBest) {
                statsManager.setStat(Statistic.FEWEST_GUESSES, guesses);
                statsManager.setStat(Statistic.SECOND_FEWEST_GUESSES, firstBest);
                statsManager.setStat(Statistic.THIRD_FEWEST_GUESSES, secondBest);
            }
            else if (guesses < secondBest) {
                statsManager.setStat(Statistic.SECOND_FEWEST_GUESSES, guesses);
                statsManager.setStat(Statistic.THIRD_FEWEST_GUESSES, secondBest);
            }
            else if (guesses < thirdBest) {
                statsManager.setStat(Statistic.THIRD_FEWEST_GUESSES, guesses);
            }
        }

    }
}
