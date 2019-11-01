package com.example.game.level3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.game.R;
import com.example.game.data.Setting;
import com.example.game.data.Statistic;
import com.example.game.services.GameData;
import com.example.game.services.SettingsManager;
import com.example.game.services.SettingsManagerBuilder;
import com.example.game.services.StatsManager;
import com.example.game.services.StatsManagerBuilder;

import java.time.Duration;
import java.util.ArrayList;

/**
 * The activity that appears right before the user is about to start a game of Cows and Bulls.
 */
public class CowsBullsActivity extends AppCompatActivity {
    private TextView timer;
    private EditText guess;
    static String currentGuess;
    private Chronometer chronometer;
    private long elapsedTime;
    private LinearLayout linLayout;
    private GameManager gameManager;
    private int answerSize;
    private StatsManager statsManager;
    long startTime;
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
        SettingsManager settingsManager = new SettingsManagerBuilder().build(this, username);
        this.gameManager = new GameManager(4, settingsManager.getSetting(Setting.ALPHABET));

    }

    /**
     * @return - the guess input of user as a String if guess length matches GUESS_SIZE, otherwise
     * return null.
     */
    private String guessInput() {
        try {
            if (guess.getText().toString().length() > 0)
                return guess.getText().toString();
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

        if (currentGuess.length() == 4 && !currentGuess.equals("null")) {
            guess.setText("");
            String[] guessArray = currentGuess.split("");
            this.gameManager.setGuess(guessArray);

            if (getBulls() == 4) {
                long stopTime = System.currentTimeMillis();
                chronometer.stop();
                statsManager = new StatsManagerBuilder().build(this, GameData.USERNAME);
                elapsedTime = stopTime - startTime;
                int seconds = turnToSeconds(elapsedTime);
                statsManager.setStat(Statistic.TIME_TAKEN, seconds);
                int minTime = statsManager.getStat(Statistic.QUICKEST_TIME);
                if (seconds < minTime || minTime == 0) {
                    statsManager.setStat(Statistic.QUICKEST_TIME, seconds);
                }
                statsManager.setStat(Statistic.NUMBER_OF_GUESSES, getStatistics().size());
                Intent intent = new Intent(this, CowsBullsFinishActivity.class);
                startActivity(intent);
            }


            TextView currGuess = new TextView(CowsBullsActivity.this);
            String textToDisplay = currentGuess + "     Bulls: " + getBulls() + " Cows: " + getCows();
            currGuess.setText(textToDisplay);
            currGuess.setGravity(Gravity.CENTER);
            linLayout.addView(currGuess);
        }
        guess.setText("");
    }

    /**
     * Returns elapsedTime in seconds in and int
     *
     * @param elapsedTime - the time elapsed in milliSeconds
     */
    private int turnToSeconds(long elapsedTime) {
        int hours = (int) (elapsedTime / 3600000);
        int minutes = (int) (elapsedTime - hours * 3600000) / 60000;
        return (int) (elapsedTime - hours * 3600000 - minutes * 60000) / 1000;
    }

    /**
     * A method that returns the number of cows (the number of guesses in the wrong location,
     * but correct value) of the last guess.
     *
     * @return The number of cows.
     */
    public int getCows() {
        return this.gameManager.getResults()[0];
    }

    /**
     * A method that returns the number of bulls (the number of guesses in the correct location,
     * and correct value) of the last guess.
     *
     * @return The number of bulls.
     */
    public int getBulls() {
        return this.gameManager.getResults()[1];
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
