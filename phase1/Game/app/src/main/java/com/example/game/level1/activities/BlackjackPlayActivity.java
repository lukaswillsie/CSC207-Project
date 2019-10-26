package com.example.game.level1.activities;

import android.os.Bundle;
import android.view.View;
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

    public void test(View view) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player();
        Player player2 = new Player();

        for (int i = 0; i < 5; i++) {
            player1.deal(deck.deal());
        }

        for (int i = 0; i < 5; i++) {
            player2.deal(deck.deal());
        }

        PlayerInterpreter interp1 = new PlayerInterpreter(player1, new PlayerHandView((TextView) findViewById(R.id.dealerHand)));
        PlayerInterpreter interp2 = new PlayerInterpreter(player2, new PlayerHandView((TextView) findViewById(R.id.playerHand)));

        interp1.updatePlayerHandHideFirstCard();
        interp2.updatePlayerHand();
    }
}
