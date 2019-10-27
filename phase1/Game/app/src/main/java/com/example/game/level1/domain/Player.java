package com.example.game.level1.domain;

public class Player {
    /**
     * This player's hand
     */
    private Hand hand;

    /**
     * Get this player's hand
     *
     * @return this player's hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Create a new player with no hand
     */
    public Player() {
        hand = new Hand();
    }

    /**
     * Create a new player with the given starting hand
     *
     * @param hand - the player's starting hand
     */
    public Player(Hand hand) {
        this.hand = hand;
    }
}
