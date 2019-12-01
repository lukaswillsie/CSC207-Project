package com.example.game.CowsBullsGame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.data.GameData;
import com.example.game.data.MultiplayerGameData;

import java.text.MessageFormat;

public class CowsBullsStartActivity extends AppCompatActivity {

    Button startButton;

    boolean multiplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls_start);
        startButton = findViewById(R.id.toGame);
        multiplayer = GameData.MULTIPLAYER;
        if (multiplayer) {
            startButton.setText(MessageFormat.format("{0}''s Turn", MultiplayerGameData.getPlayer1Username()));
        }
    }


    /**
     * Method for button toGame to proceed to CowsBullsActivity
     */
    public void toGame(View view) {
        Intent intent = new Intent(this, CowsBullsActivity.class);
        startActivity(intent);
    }

    public void toDifficultySetting(View view){
        Intent intent = new Intent(this, CowsBullsSelectDifficultyActivity.class);
        startActivity(intent);
    }

    /**
     * Method to specify what to do when android back button is pressed
     */
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
