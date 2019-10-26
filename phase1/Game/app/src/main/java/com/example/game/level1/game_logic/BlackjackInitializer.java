package com.example.game.level1.game_logic;

import android.view.View;
import android.widget.TextView;

import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.domain.Dealer;
import com.example.game.level1.domain.Deck;
import com.example.game.level1.domain.Player;

public class BlackjackInitializer implements LevelInitializer {
    private LevelManager gameManager;

    public BlackjackInitializer(TextView userHand, TextView dealerHand, ButtonManager buttonManager) {
        Player user = new Player();
        Dealer dealer = new Dealer();
        Deck deck = new Deck();

        InterfaceManager interfaceManager = new BlackjackInterfaceManager(user, dealer, userHand, dealerHand);
        gameManager = new BlackjackLevelManager(user, dealer, deck, interfaceManager, buttonManager);
    }

    public LevelManager setup() {
        gameManager.setup();

        return gameManager;
    }
}
