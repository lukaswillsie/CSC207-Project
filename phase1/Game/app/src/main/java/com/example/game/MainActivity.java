package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.game.GameConstants.NAME_KEY;
import static com.example.game.GameConstants.TAG;
import static com.example.game.GameConstants.USERNAME_KEY;

import com.example.game.level2.GameStartActivity;
import com.example.game.level1.activities.BlackjackStartActivity;

public class MainActivity extends AppCompatActivity {
    private String nameOfUser;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameOfUser = getIntent().getStringExtra(TAG + NAME_KEY);
        username = getIntent().getStringExtra(TAG + USERNAME_KEY);
        String welcomeText = "Welcome, " + nameOfUser + "!";
        ((TextView)findViewById(R.id.welcomeText)).setText(welcomeText);
    }

    public void playBlackjack(View view){
        Intent intent = new Intent(this, BlackjackStartActivity.class);
        startActivity(intent);
    }
    public void chooseTheNum(View view){
        Intent intent = new Intent(this, GameStartActivity.class);
        startActivity(intent);
    }

    public void goToSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra(TAG + NAME_KEY, nameOfUser);
        intent.putExtra(TAG + USERNAME_KEY, username);
        startActivity(intent);
    }
}
