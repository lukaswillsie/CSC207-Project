package com.example.game.level1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.R;

import org.w3c.dom.Text;

public class BlackjackPlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_play);
    }

    public void test(View view){
        Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player();
        Player player2 = new Player();

        for(int i = 0; i < 5; i++){
            player1.deal(deck.deal());
        }

        for(int i = 0; i < 5; i++){
            player2.deal(deck.deal());
        }

        PlayerInterpreter interp1 = new PlayerInterpreter(player1, new PlayerHandView((TextView) findViewById(R.id.dealerHand)));
        PlayerInterpreter interp2 = new PlayerInterpreter(player2, new PlayerHandView((TextView) findViewById(R.id.playerHand)));

        interp1.updatePlayerHandHideFirstCard();
        interp2.updatePlayerHand();
    }
}
