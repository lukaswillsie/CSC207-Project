package com.example.game.level1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;
import com.example.game.data.Setting;
import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.game_logic.LevelManager;
import com.example.game.level1.services.LevelManagerBuilder;
import com.example.game.services.GameData;
import com.example.game.services.SettingsManagerBuilder;

public class BlackjackPlayActivity extends AppCompatActivity {
    /**
     * Constants that record the IDs of the various UI elements
     * To be used throughout this level as objects interact with UI elements
     */
    public static final int PLAYER_HAND_ID = R.id.playerHand;
    public static final int DEALER_HAND_ID = R.id.dealerHand;
    public static final int END_GAME_TEXT_ID = R.id.endGameText;
    public static final int HIT_BUTTON_ID = R.id.hitButton;
    public static final int STAND_BUTTON_ID = R.id.standButton;
    public static final int END_GAME_BUTTON_ID = R.id.endGameButton;
    public static final int PLAY_AGAIN_BUTTON_ID = R.id.playAgainButton;

    /**
     * The note to be displayed at the top of the screen
     */
    private static final String note = "Note: A \u2588 represents a card the dealer has that you can't see";

    /**
     * The LevelManager that will play the game taking place in this activity
     */
    public static LevelManager levelManager;

    /**
     * The player's score
     */
    private int score;

    /**
     * The number of hands this player chose to play in their settings
     */
    private int numHands;

    /**
     * The number of hands this player has played so far
     */
    private int numHandsPlayed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_play);

        ButtonManager.setup(this);

        LevelManagerBuilder builder = new LevelManagerBuilder();
        levelManager = builder.build(this);

        levelManager.setup();
        levelManager.play();

        score = getIntent().getIntExtra(BlackjackStartActivity.tag + ".score", 0);

        String scoreText = "Score: " + score;
        ((TextView) findViewById(R.id.playScore)).setText(scoreText);

        numHands = new SettingsManagerBuilder().build(this, GameData.USERNAME).getSetting(Setting.NUM_HANDS);
        
        ((TextView)findViewById(R.id.blackjackNote)).setText(note);
    }

    /**
     * Pass on to the levelManager that a button has been clicked
     *
     * @param view - the button that was clicked
     */
    public void buttonClick(View view) {
        levelManager.userButtonClick(view);
    }

    /**
     * Refresh the game. Erase the end game text, "play again" button, and "next" button,
     * and initialize a new LevelManager and therefore a new game
     *
     * @param view - the button that was clicked
     */
    public void playAgain(View view) {
        LevelManagerBuilder builder = new LevelManagerBuilder();
        levelManager = builder.build(this);

        ButtonManager.makeButtonInvisible(END_GAME_BUTTON_ID);
        ButtonManager.makeButtonInvisible(PLAY_AGAIN_BUTTON_ID);
        ButtonManager.enableButton(HIT_BUTTON_ID);
        ButtonManager.enableButton(STAND_BUTTON_ID);

        findViewById(END_GAME_TEXT_ID).setVisibility(View.INVISIBLE);

        levelManager.setup();
        levelManager.play();
    }

    /**
     * Move to the EndGame screen
     *
     * @param view - the button that was clicked
     */
    public void endGame(View view) {
        Intent intent = new Intent(this, EndGameActivity.class);
        startActivity(intent);
    }

    /**
     * Make the "play again" button and the "next" button visible, and display the given end of game
     * text
     *
     * @param endGameText - the text to display as a result of the game ending
     */
    public void gameOver(String endGameText, boolean playerWin) {
        numHandsPlayed++;
        if(numHandsPlayed == numHands){
            ButtonManager.makeVisible(END_GAME_BUTTON_ID);
        }
        else {
            ButtonManager.makeVisible(PLAY_AGAIN_BUTTON_ID);
        }
        TextView endGameTextView = findViewById(END_GAME_TEXT_ID);
        endGameTextView.setText(endGameText);
        endGameTextView.setVisibility(View.VISIBLE);

        if (playerWin) {
            score += 100;
        } else {
            score -= 50;
        }

        String scoreText = "Score: " + score;
        ((TextView) findViewById(R.id.playScore)).setText(scoreText);
    }
}
