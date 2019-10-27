package com.example.game.level1.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand implements Iterable<Card> {
    /**
     * An array of cards representing this hand
     */
    private ArrayList<Card> hand;

    /**
     * Create an empty hand
     */
    Hand() {
        hand = new ArrayList<>();
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

        HandIterator() {
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
