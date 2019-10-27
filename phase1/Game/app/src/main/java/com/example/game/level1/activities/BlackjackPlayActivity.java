package com.example.game.level1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;
import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.game_logic.LevelManager;
import com.example.game.level1.services.LevelManagerBuilder;

import java.util.ArrayList;
import java.util.List;

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
     * A list of the IDs of all the buttons on the UI
     */
    public static final int[] buttonIds = {R.id.hitButton, R.id.standButton, R.id.endGameButton, R.id.playAgainButton};

    /**
     * The LevelManager that will play the game taking place in this activity
     */
    public static LevelManager levelManager;

    /**
     * The ButtonManager this Activity will be using to interact with buttons in the UI
     */
    private ButtonManager buttonManager;

    /**
     * The player's score
     */
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_play);

        LevelManagerBuilder builder = new LevelManagerBuilder();
        levelManager = builder.buildLevelManager(this);

        levelManager.setup();
        levelManager.play();

        List<Button> buttons = new ArrayList<Button>();
        for(int id : buttonIds){
            buttons.add((Button)findViewById(id));
        }

        buttonManager = new ButtonManager(buttons);

        score = getIntent().getIntExtra(BlackJackStartActivity.tag + ".score", 0);

        String scoreText = "Score: " + score;
        ((TextView)findViewById(R.id.playScore)).setText(scoreText);
    }

    /**
     * Pass on to the levelManager that a button has been clicked
     * @param view - the button that was clicked
     */
    public void buttonClick(View view){
        levelManager.userButtonClick(view);
    }

    /**
     * Refresh the game. Erase the end game text, "play again" button, and "next" button,
     * and initialize a new LevelManager and therefore a new game
     * @param view - the button that was clicked
     */
    public void playAgain(View view){
        LevelManagerBuilder builder = new LevelManagerBuilder();
        levelManager = builder.buildLevelManager(this);

        buttonManager.makeButtonInvisible(END_GAME_BUTTON_ID);
        buttonManager.makeButtonInvisible(PLAY_AGAIN_BUTTON_ID);
        buttonManager.enableButton(HIT_BUTTON_ID);
        buttonManager.enableButton(STAND_BUTTON_ID);

        findViewById(END_GAME_TEXT_ID).setVisibility(View.INVISIBLE);

        levelManager.setup();
        levelManager.play();
    }

    /**
     * Move to the EndGame screen
     * @param view - the button that was clicked
     */
    public void endGame(View view){
        Intent intent = new Intent(this, EndGameActivity.class);
        startActivity(intent);
    }

    /**
     * Make the "play again" button and the "next" button visible, and display the given end of game
     * text
     * @param endGameText - the text to display as a result of the game ending
     */
    public void gameOver(String endGameText, boolean playerWin){
        TextView endGameTextView = ((TextView)findViewById(END_GAME_TEXT_ID));
        endGameTextView.setText(endGameText);
        endGameTextView.setVisibility(View.VISIBLE);

        buttonManager.makeVisible(END_GAME_BUTTON_ID);

        buttonManager.makeVisible(PLAY_AGAIN_BUTTON_ID);

        if(playerWin){
            score += 100;
        }
        else{
            score -= 50;
        }

        String scoreText = "Score: " + score;
        ((TextView)findViewById(R.id.playScore)).setText(scoreText);
    }
}
