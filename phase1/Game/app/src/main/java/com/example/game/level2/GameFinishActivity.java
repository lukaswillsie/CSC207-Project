package com.example.game.level2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.MainActivity;
import com.example.game.R;

public class GameFinishActivity extends AppCompatActivity{
    GameManager gameManager = GameStartActivity.gameManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_finish_activity);
        Game currentGame = gameManager.GetAGame();
        currentGame.setIsFinished();
        ((TextView)findViewById(R.id.points16)).setText(String.valueOf(currentGame.getPoints()));
        ((TextView)findViewById(R.id.finalGuesses)).setText(String.valueOf(currentGame.getNumOfGuess()));
    }

    public void mainMenuClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void playAgainClick(View view) {
        Intent intent = new Intent(this, GameStartActivity1.class);
        gameManager.startNewGame();
        startActivity(intent);
    }

}
