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

    /**
     * Add the given card to this player's hand
     *
     * @param card - the card to add to this player's hand
     */
    public void deal(Card card) {
        this.hand.addCard(card);
    }

    /**
     * Deal multiple cards to this player at a time
     *
     * @param cards - the array of cards to add to this player's hand
     */
    public void deal(Card[] cards) {
        for (Card card : cards) {
            deal(card);
        }
    }
}