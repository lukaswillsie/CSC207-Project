package com.example.game.level2;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.game.R;

public class GameStartActivity1 extends AppCompatActivity{
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
        // execute what happens when a guess is submitted.
    }

}
