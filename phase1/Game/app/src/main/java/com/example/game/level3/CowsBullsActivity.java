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

public class CowsBullsActivity extends AppCompatActivity {
    private TextView timer;
    private EditText guess;
    static String currentGuess;
    private String smiley = ("☺");
    private Chronometer chronometer;
    private long elapsedTime;
    private LinearLayout linLayout;




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
     *
     * @return - the guess input of user as a String if guess length matches GUESS_SIZE, otherwise
     * return -1
     */
    private String guessInput() {
        try {
            if (guess.getText().toString().length() > 0)
                return guess.getText().toString();
            return "null";
        } catch (Exception e){
            return "null";
        }
    }

    /**
     * This method performs the tasks after user had made a guess through the interface.
     * @param view - view of the Activity
     */
    public void checkGuess (View view){
        currentGuess = guessInput();

        guess.setText("");

        TextView currGuess = new TextView(CowsBullsActivity.this);
        currGuess.setText(currentGuess);
        linLayout.addView(currGuess);








    }

    @Override
    protected void onStop(){
        super.onStop();
    }
}
