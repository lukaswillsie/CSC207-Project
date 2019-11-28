package com.example.game.CowsBullsGame.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.CowsBullsGame.domain.Guess;
import com.example.game.CowsBullsGame.game_logic.GameManager;
import com.example.game.CowsBullsGame.game_logic.TurnData;
import com.example.game.CowsBullsGame.services.CowsBullsStatsManager;
import com.example.game.R;
import com.example.game.data.GameData;
import com.example.game.data.Setting;
import com.example.game.services.settings.SettingsManager;
import com.example.game.services.settings.SettingsManagerBuilder;
import com.example.game.services.stats.StatsManager;
import com.example.game.services.stats.StatsManagerBuilder;

import java.util.ArrayList;

public class CowsBullsSecondPlayerActivity extends AppCompatActivity {

    private Activity activity;

    // The text view for user input.
    private EditText guess;

    // The last guess that was made.
    static String currentGuess;

    // The timer for this game.
    private Chronometer chronometer;

    // The layout for the past guesses in the game.
    private LinearLayout linLayout;

    // The GameManager for this game.
    private GameManager gameManager;

    //The StatsManager for this game.
    private StatsManager statsManager;

    //The SettingsManager for this game.
    private SettingsManager settingsManager;

    //The CowsBullsStatsManager for this game.
    private CowsBullsStatsManager cowsBullsStatsManager;

    // The time in milliseconds when the player started the game.
    private long startTime;

    //Indicates whether multiplayer mode is on
    private boolean multiplayer;

    // The player's username.
    String username = GameData.USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls);


        startTime = System.currentTimeMillis();
        chronometer = findViewById(R.id.timer);
        chronometer.start();
        guess = findViewById(R.id.guessNumber);
        linLayout = findViewById(R.id.linLayout);
        settingsManager = new SettingsManagerBuilder().build(this, username);
        statsManager = new StatsManagerBuilder().build(this, GameData.USERNAME);
        gameManager = new GameManager(5, settingsManager.getSetting(Setting.ALPHABET));
        cowsBullsStatsManager = new CowsBullsStatsManager(statsManager);
        multiplayer = GameData.MULTIPLAYER;

        if (settingsManager.getSetting(Setting.ALPHABET) == 1) {
            guess.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            guess.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * @return - the guess input of user as a String if guess length matches GUESS_SIZE, otherwise
     * return null.
     */
    private String guessInput() {
        try {
            if (guess.getText().toString().length() > 0)
                return guess.getText().toString().replaceAll("\\s+", "");
            return "null";
        } catch (Exception e) {
            return "null";
        }
    }

    /**
     * This method performs the tasks after user had made a guess through the interface.
     *
     * @param view - view of the Activity
     */
    public void checkGuess(View view) {
        currentGuess = guessInput();

        System.out.println(gameManager.checkGuess(currentGuess) + " " + currentGuess);
        if (gameManager.checkGuess(currentGuess)) {
            Guess guessArray = new Guess(currentGuess);


            this.gameManager.setGuess(guessArray);
            int bulls = this.gameManager.getResults()[1];
            int cows = this.gameManager.getResults()[0];

            if (gameManager.gameEnd()) {
                long stopTime = System.currentTimeMillis();
                chronometer.stop();
                long elapsedTime = stopTime - startTime;
                int seconds = turnToSeconds(elapsedTime);
                int numberOfGuesses = getStatistics().size();
                cowsBullsStatsManager.update(seconds, numberOfGuesses);

                Intent intent = new Intent(this, CowsBullsFinishActivity.class);
                startActivity(intent);
            }

            TextView currGuess = new TextView(CowsBullsSecondPlayerActivity.this);
            String textToDisplay = currentGuess + "     Bulls: " + bulls + " Cows: " + cows;
            currGuess.setText(textToDisplay);
            currGuess.setGravity(Gravity.CENTER);
            linLayout.addView(currGuess);

            if (multiplayer) {
                Intent intent = new Intent(this, CowsBullsActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
        guess.setText("");
    }

    /**
     * Returns elapsedTime in seconds in and int
     *
     * @param elapsedTime - the time elapsed in milliSeconds
     */
    private int turnToSeconds(long elapsedTime) {
        return (int) (elapsedTime / 1000);
    }


    /**
     * A method that returns all of the data / statistics collected so far in level 3.
     *
     * @return An array of TurnData objects which store the data for each turn.
     */
    public ArrayList<TurnData> getStatistics() {
        return this.gameManager.getStatistics();
    }
}



