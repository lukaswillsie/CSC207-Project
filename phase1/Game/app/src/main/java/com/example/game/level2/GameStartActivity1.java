package com.example.game.level2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.game.R;

public class GameStartActivity1 extends AppCompatActivity{
    GameManager gameManager = GameStartActivity.gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity1);
    }

    private int getGuess() {
        return Integer.valueOf(((TextView)findViewById(R.id.guessInput)).getText().toString());
    }

    public void submitGuess() {
        int guess = getGuess();
        Game currentGame = gameManager.game;
        if (currentGame.checkTheRightGuess(guess)){
            Intent intent = new Intent(this, GameFinishActivity.class);
            startActivity(intent);
        }
        else{
            if (currentGame.checkGuess(guess)){
                Intent intent = new Intent(this, GameHighActivity.class);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(this, GameLowActivity.class);
                startActivity(intent);
            }
        }
        // execute what happens when a guess is submitted.
    }

}
