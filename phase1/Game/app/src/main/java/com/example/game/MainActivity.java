package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.level2.GameStartActivity;
import com.example.game.level1.activities.BlackJackStartActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view){
        Intent intent = new Intent(this, BlackJackStartActivity.class);
        startActivity(intent);
    }
    public void chooseTheNum(View view){
        Intent intent = new Intent(this, GameStartActivity.class);
        startActivity(intent);
    }
}
