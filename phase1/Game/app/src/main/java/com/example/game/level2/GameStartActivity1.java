package com.example.game.level2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.MainActivity;
import com.example.game.R;

public class GameStartActivity1 extends AppCompatActivity{
    GameManager gameManager = GameStartActivity.gameManager;
    static int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Game currentGame = gameManager.game;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity1);
        ((TextView)findViewById(R.id.pointsFinishId)).setText(String.valueOf(currentGame.getPoints()));
        ((TextView)findViewById(R.id.guessesId)).setText(String.valueOf(currentGame.getNumOfGuess()));
    }

    private int getGuess() {
        return Integer.valueOf(((TextView)findViewById(R.id.guessInput)).getText().toString());
    }

    public void submitGuess(View view) {
        guess = getGuess();
        Game currentGame = gameManager.game;
        ((TextView)findViewById(R.id.guessInput)).setText("");

        if (currentGame.checkTheRightGuess(guess)){
            Intent intent = new Intent(this, GameFinishActivity.class);
            startActivity(intent);
        }
        else{
            if (currentGame.checkGuess(guess)){
                //((TextView)findViewById(R.id.textView)).setVisibility(View.INVISIBLE);
                ((TextView)findViewById(R.id.textView)).setText("Your guess is too high, try again.");
            }
            else{
                ((TextView)findViewById(R.id.textView)).setText("Your guess is too low, try again.");
            }
            ((TextView)findViewById(R.id.pointsFinishId)).setText(String.valueOf(currentGame.getPoints()));
            ((TextView)findViewById(R.id.guessesId)).setText(String.valueOf(currentGame.getNumOfGuess()));
        }
        // execute what happens when a guess is submitted.
    }

    public void pauseExit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
