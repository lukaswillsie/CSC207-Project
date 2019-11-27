package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.data.GameData;

import java.io.IOException;

/**
 * The page displayed when the app initially starts up
 */
public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        if (GameData.MULTIPLAYER) {
            findViewById(R.id.multiplayerLoginTitle).setVisibility(View.VISIBLE);
        }

        initializeGame();
    }

    public void newAccount(View view) {
        Intent intent = new Intent(this, NewAccountActivity.class);
        startActivity(intent);
    }

    public void oldAccount(View view) {
        Intent intent = new Intent(this, OldAccountActivity.class);
        startActivity(intent);
    }

    public void Test(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * A method for any code that needs to be run when the game starts
     */
    private void initializeGame() {
        try {
            GameData.setFilesDirPath(this.getFilesDir().getCanonicalPath());
        } catch (IOException e) {
            Log.e("StartActivity", "Failed to set root directory path");
        }
    }
}
