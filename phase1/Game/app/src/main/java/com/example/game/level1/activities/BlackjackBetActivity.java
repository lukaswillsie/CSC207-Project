package com.example.game.level1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.R;

import org.w3c.dom.Text;

public class BlackjackBetActivity extends AppCompatActivity {
    public static String tag = "com.example.game.level1.activities.BlackjackBetActivity";
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_bet);
        score = getIntent().getIntExtra(BlackJackStartActivity.tag + ".score", 0);
        String scoreText = "Your Score: " + score;
        ((TextView)findViewById(R.id.scoreDisplay)).setText(scoreText);
    }

    public void bet(View view){
        int bet = Integer.parseInt(((TextView)findViewById(R.id.betText)).getText().toString());
        if(bet <= score){
            Intent intent = new Intent(this, BlackjackPlayActivity.class);
            intent.putExtra(tag + ".bet", bet);
            startActivity(intent);
        }
        else{

        }
    }
}
