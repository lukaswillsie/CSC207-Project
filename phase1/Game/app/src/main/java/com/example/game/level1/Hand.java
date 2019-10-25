package com.example.game.level1;

import java.util.ArrayList;

public class Hand {
    /**
     * An array of cards representing this hand
     */
    private ArrayList<Card> hand;

    /**
     * Return a copy of the cards in this hand
     *
     * @return A shallow copy of the cards in this hand
     */
    public ArrayList<Card> getHand() {
        return new ArrayList<>(hand);
    }

    /**
     * Create an empty hand
     */
    public Hand() {
        hand = new ArrayList<>();
    }

    /**
     * Create a hand with the given cards in it
     *
     * @param hand - The initial cards in the hand
     */
    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}
