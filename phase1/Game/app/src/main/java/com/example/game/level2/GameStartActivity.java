package com.example.game.level2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.game.R;

public class GameStartActivity extends AppCompatActivity {
    public static GameManager gameManager = new GameManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);
        Button btn = findViewById(R.id.resumeGame);
        Game game = gameManager.GetAGame();
        if (game.isFinished() || game.getPoints() == 0) {
            btn.setVisibility(View.INVISIBLE);
        }
        else {
            btn.setVisibility(View.VISIBLE);;
        }
        // create a SettingsManager
        // pass in this
    }

    public void startTheGame(View view){
        gameManager.startNewGame();
        Intent intent = new Intent(this, GameStartActivity1.class);
        startActivity(intent);
    }

    public void resumeGame(View view) {
        // execute what happens when you resume a previous game
        Intent intent = new Intent(this, GameStartActivity1.class);
        startActivity(intent);
    }


}
