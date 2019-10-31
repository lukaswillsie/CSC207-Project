package com.example.game.level1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.data.GameConstants;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView longestStreakDisplay = findViewById(R.id.longestStreakDisplay);
        String longestStreak = ""+getIntent().getIntExtra(GameConstants.TAG + GameConstants.LONGEST_STREAK_KEY, 0);
        longestStreakDisplay.setText(longestStreak);
        ((TextView)findViewById(R.id.winRateDisplay)).setText(getIntent().getStringExtra(GameConstants.TAG + GameConstants.WIN_RATE_KEY));
    }


    public void playAnotherRound(View view)
    {
        Intent intent = new Intent(this, BlackjackPlayActivity.class);
        startActivity(intent);
    }

    public void mainMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
