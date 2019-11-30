package com.example.game.CowsBullsGame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.game.BlackjackGame.activities.BlackjackPlayActivity;
import com.example.game.R;
import com.example.game.services.multiplayer_data.MultiplayerDataManagerFactory;

import static com.example.game.data.MultiplayerIntData.BLACKJACK_PLAYER_TURN;

public class CowsBullsMidMultiplayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls_mid_multiplayer);
    }

    public void player2Turn(View view) {
        Intent intent = new Intent(this, BlackjackPlayActivity.class);

        // Record that it is now player 2's turn
        new MultiplayerDataManagerFactory().build().setMultiplayerData(BLACKJACK_PLAYER_TURN, 2);
        startActivity(intent);
    }
}
