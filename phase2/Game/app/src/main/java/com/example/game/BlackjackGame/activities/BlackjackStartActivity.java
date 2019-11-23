package com.example.game.BlackjackGame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.BlackjackGame.domain.Suit;
import com.example.game.R;
import com.example.game.data.GameData;

import java.util.ArrayList;
import java.util.List;

import static com.example.game.data.GameConstants.USERNAME_KEY;
import static com.example.game.data.GameConstants.TAG;

/**
 * The page that introduces the player to Blackjack
 */
public class BlackjackStartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.black_jack_start);
        ((TextView) findViewById(R.id.blackjackBlurb)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * The method called when the "start" button is clicked; starts BlackjackPlayActivity
     *
     * @param view - the View that called this method
     */
    public void startGame(View view) {
        Intent intent = new Intent(this, BlackjackPlayActivity.class);
        intent.putExtra(TAG + USERNAME_KEY, GameData.USERNAME);
        // TODO: Reminder to not forget to change these lines of code after done testing Blackjack multiplayer
        GameData.setMultiplayer(true);
        //
        startActivity(intent);
    }
}
