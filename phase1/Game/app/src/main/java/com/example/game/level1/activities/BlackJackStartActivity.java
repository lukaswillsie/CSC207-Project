package com.example.game.level1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.R;

public class BlackJackStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.black_jack_start);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, BlackjackPlayActivity.class);
        startActivity(intent);
    }
}
