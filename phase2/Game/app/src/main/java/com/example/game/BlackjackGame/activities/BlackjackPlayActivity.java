package com.example.game.BlackjackGame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.BlackjackGame.services.StatsRecorder;
import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.data.MultiplayerDoubleData;
import com.example.game.services.ButtonManager;
import com.example.game.BlackjackGame.game_logic.BlackjackLevelManager;
import com.example.game.BlackjackGame.services.BlackjackLevelManagerBuilder;
import com.example.game.services.GameData;
import com.example.game.services.MultiplayerDataManager;
import com.example.game.services.TestMultiplayerDataManager;

import java.text.DecimalFormat;

import static com.example.game.data.GameConstants.LONGEST_STREAK_KEY;
import static com.example.game.data.GameConstants.TAG;
import static com.example.game.data.GameConstants.WIN_RATE_KEY;
import static com.example.game.data.MultiplayerDoubleData.BLACKJACK_PLAYER_1_WIN_RATE;
import static com.example.game.data.MultiplayerDoubleData.BLACKJACK_PLAYER_2_WIN_RATE;
import static com.example.game.data.MultiplayerIntData.BLACKJACK_PLAYER_TURN;
import static com.example.game.data.MultiplayerIntData.PLAYER1_LONGEST_STREAK;
import static com.example.game.data.MultiplayerIntData.PLAYER2_LONGEST_STREAK;

/**
 * The page displayed when the user is actually playing a round of Blackjack
 */
public class BlackjackPlayActivity extends AppCompatActivity implements BlackjackPlayPage {
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
    public static BlackjackLevelManager levelManager;

    /**
     * The class managing the buttons in this Activity
     */
    private ButtonManager buttonManager;

    /**
     * The object this class will use to manage multiplayer data if necessary
     */
    private MultiplayerDataManager multiplayerDataManager;

    /**
     * The StatsRecorder this activity will be using to track the player's game statistics while
     * the game is being played
     */
    private StatsRecorder statsRecorder;

    /**
     * Tells this activity whether or not the game of Blackjack it is displaying is part of a round
     * of multiplayer
     */
    private boolean multiplayer;

    /**
     * If multiplayer = true, tells this activity whether the game being played is the for player 1
     * or player 2
     */
    private boolean player1Turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_play);
        // TODO: Write an actual implementation of MultiplayerDataManager and use dependency injection to get it into this class
        multiplayerDataManager = new TestMultiplayerDataManager();
        multiplayer = GameData.MULTIPLAYER;
        player1Turn = multiplayerDataManager.getMultiplayerData(BLACKJACK_PLAYER_TURN) == 1;

        // Initialize username according to whether or not this is a multiplayer game
        String username;
        if(GameData.MULTIPLAYER){
            if(multiplayerDataManager.getMultiplayerData(BLACKJACK_PLAYER_TURN) == 1){
                username = multiplayerDataManager.getPlayer1Username();
            }
            else {
                username = multiplayerDataManager.getPlayer2Username();
            }
        }
        else {
            username = GameData.USERNAME;
        }

        buttonManager = new ButtonManager(this);

        BlackjackLevelManagerBuilder builder = new BlackjackLevelManagerBuilder();
        levelManager = builder.build(this, username);

        levelManager.setup();
        levelManager.play();

        ((TextView) findViewById(R.id.blackjackNote)).setText(note);

        statsRecorder = new StatsRecorder(this, username);
    }

    /**
     * Pass on to the levelManager that a button has been clicked
     *
     * @param view - the button that was clicked
     */
    public void buttonClick(View view) {
        if (view.getId() == HIT_BUTTON_ID) {
            levelManager.playerHit();
        } else if (view.getId() == STAND_BUTTON_ID) {
            levelManager.playerStand();
        }
    }

    /**
     * Refresh the game. Erase the end game text, "play again" button, and "next" button,
     * and initialize a new LevelManager and therefore a new game
     *
     * @param view - the button that was clicked
     */
    public void playAgain(View view) {
        buttonManager.makeButtonInvisible(END_GAME_BUTTON_ID);
        buttonManager.makeButtonInvisible(PLAY_AGAIN_BUTTON_ID);
        buttonManager.enableButton(HIT_BUTTON_ID);
        buttonManager.enableButton(STAND_BUTTON_ID);

        findViewById(END_GAME_TEXT_ID).setVisibility(View.INVISIBLE);

        levelManager.playAgain();
    }

    /**
     * Move to the EndGame screen
     *
     * @param view - the button that was clicked
     */
    public void endGame(View view) {
        Intent intent;
        // The intent that should be started depends on whether or not this was a multiplayer game
        if(multiplayer){
            if(player1Turn){
                intent = new Intent(this, BlackjackMidMultiplayerActivity.class);
                multiplayerDataManager.setMultiplayerData(PLAYER1_LONGEST_STREAK, statsRecorder.getLongestStreak());
                multiplayerDataManager.setMultiplayerData(BLACKJACK_PLAYER_1_WIN_RATE, formatWinRate(statsRecorder.getWinRate()) );
            }
            else {
                intent = new Intent(this, MultiplayerEndGameActivity.class);
                multiplayerDataManager.setMultiplayerData(PLAYER2_LONGEST_STREAK, statsRecorder.getLongestStreak());
                multiplayerDataManager.setMultiplayerData(BLACKJACK_PLAYER_2_WIN_RATE, formatWinRate(statsRecorder.getWinRate()));
            }
        }
        else {
            intent = new Intent(this, EndGameActivity.class);
            intent.putExtra(TAG + WIN_RATE_KEY, new DecimalFormat("##.##").format(100 * (statsRecorder.getWinRate())) + "%");
            intent.putExtra(TAG + LONGEST_STREAK_KEY, statsRecorder.getLongestStreak());
        }
        startActivity(intent);
    }

    private double formatWinRate(double winRate){
        return (double)((int)(winRate * 100) / 100);
    }

    /**
     * Record that the round ended. Make the "play again" button and the "next" button visible, and display the given end of game
     * text
     *
     * @param endGameText - the text to display as a result of the game ending
     */
    public void gameOver(String endGameText, boolean playerWin) {
        buttonManager.disableButton(BlackjackPlayActivity.HIT_BUTTON_ID);
        buttonManager.disableButton(BlackjackPlayActivity.STAND_BUTTON_ID);

        if (levelManager.anotherRound()) {
            buttonManager.makeVisible(PLAY_AGAIN_BUTTON_ID);
        } else {
            buttonManager.makeVisible(END_GAME_BUTTON_ID);
        }

        // TODO: Consider creating TextViewManager class to do what ButtonManager does except for TextViews
        TextView endGameTextView = findViewById(END_GAME_TEXT_ID);
        endGameTextView.setText(endGameText);
        endGameTextView.setVisibility(View.VISIBLE);

        if (playerWin) {
            statsRecorder.playerWin();
        } else {
            statsRecorder.playerLose();
        }

        statsRecorder.update();
    }
}