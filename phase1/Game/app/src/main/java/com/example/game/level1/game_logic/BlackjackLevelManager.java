package com.example.game.level1.game_logic;

import com.example.game.level1.domain.Deck;
import com.example.game.level1.domain.Player;

public class BlackjackLevelManager implements LevelManager {
    public static boolean playerTurn = false;

    private Player user;
    private Player dealer;
    private Deck deck;
    private InterfaceManager interfaceManager;

    public BlackjackLevelManager(Player user, Player dealer, Deck deck, InterfaceManager interfaceManager) {
        this.user = user;
        this.dealer = dealer;
        this.deck = deck;
        this.interfaceManager = interfaceManager;
    }

    @Override
    public void setup() {
        user.deal(deck.deal(2));
        dealer.deal(deck.deal(2));
    }

    @Override
    public void play() {
        playerTurn = true;
        interfaceManager.update();
    }
}
