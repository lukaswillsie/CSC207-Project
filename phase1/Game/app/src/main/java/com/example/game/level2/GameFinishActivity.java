package com.example.game.level2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.R;

public class GameFinishActivity extends AppCompatActivity{
    GameManager gameManager = GameStartActivity.gameManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_finish_activity);
    }
}
