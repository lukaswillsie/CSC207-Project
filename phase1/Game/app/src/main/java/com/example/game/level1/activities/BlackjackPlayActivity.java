package com.example.game.level1.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;
import com.example.game.level1.display.PlayerHandView;
import com.example.game.level1.display.PlayerInterpreter;
import com.example.game.level1.domain.Deck;
import com.example.game.level1.domain.Player;
import com.example.game.level1.game_logic.LevelInitializer;
import com.example.game.level1.game_logic.LevelManager;
import com.example.game.level1.services.LevelInitializerBuilder;

public class BlackjackPlayActivity extends AppCompatActivity {
    public static final int PLAYER_HAND_ID = R.id.playerHand;
    public static final int DEALER_HAND_ID = R.id.dealerHand;
    public static final int END_GAME_TEXT_ID = R.id.endGameText;
    public static final int END_GAME_BUTTON_ID = R.id.end_game_button;
    public static final int[] buttonIds = {R.id.hitButton, R.id.standButton, R.id.end_game_button};
    public static LevelManager levelManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_play);

        LevelInitializerBuilder builder = new LevelInitializerBuilder();
        LevelInitializer initializer = builder.buildLevelInitializer(this);

        levelManager = initializer.setup();
        levelManager.play();
    }

    public void buttonClick(View view){
        levelManager.userButtonClick(view);
    }

    public void gameOver(String endGameText){
        TextView endGameTextView = ((TextView)findViewById(END_GAME_TEXT_ID));
        endGameTextView.setText(endGameText);
        endGameTextView.setVisibility(View.VISIBLE);

        Button endGameButton = ((Button) findViewById(END_GAME_BUTTON_ID));
        endGameButton.setVisibility(View.VISIBLE);
    }
}
