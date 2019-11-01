package com.example.game.level3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.game.R;

import java.util.ArrayList;

public class CowsBullsActivity extends AppCompatActivity {
    private TextView timer;
    private EditText guess;
    static String currentGuess;
    private String smiley = ("☺");
    private Chronometer chronometer;
    private long elapsedTime;
    private LinearLayout linLayout;
    private GameManager gameManager;
    private int answerSize;
    private String[] alphabet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls);

        chronometer = findViewById(R.id.timer);
        chronometer.start();
        guess = findViewById(R.id.guessNumber);
        linLayout = findViewById(R.id.linLayout);

    }

    /**
     * @return - the guess input of user as a String if guess length matches GUESS_SIZE, otherwise
     * return -1
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

        guess.setText("");

        String[] guessArray = currentGuess.split("");

        this.gameManager = new GameManager(this.answerSize, this.alphabet);

        TextView currGuess = new TextView(CowsBullsActivity.this);
        currGuess.setText(currentGuess);
        linLayout.addView(currGuess);
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

    @Override
    protected void onStop() {
        super.onStop();
    }
}
