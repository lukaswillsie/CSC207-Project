package com.example.game.level1.domain;

import java.util.ArrayList;
import java.util.Iterator;

import static com.example.game.level1.domain.Rank.ACE;

public class Hand implements Iterable<Card> {
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

    /**
     * Add the given card to this hand
     *
     * @param card - the card to be added to this hand
     */
    void addCard(Card card) {
        this.hand.add(card);
    }

    public Iterator<Card> iterator() {
        return new HandIterator();
    }

    private class HandIterator implements Iterator<Card> {
        private int index;

        public HandIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < hand.size();
        }

        public Card next() {
            return hand.get(index++);
        }
    }
}
