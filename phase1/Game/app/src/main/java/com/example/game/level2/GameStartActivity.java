package com.example.game.level2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.R;

public class GameStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);
    }

    public void startTheGame(View view){
        Intent intent = new Intent(this, GameStartActivity1.class);
        startActivity(intent);
    }
}
