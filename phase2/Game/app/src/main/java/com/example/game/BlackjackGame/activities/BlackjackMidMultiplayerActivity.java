package com.example.game.BlackjackGame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;

public class BlackjackMidMultiplayerActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_multiplayer);
    }

    public void player2Turn(View view){
        Intent intent = new Intent(this, BlackjackPlayActivity.class);
        startActivity(intent);
    }
}
