package com.example.game.level1.domain;

public class Card {
    /**
     * The rank of this playing card
     */
    private Rank rank;

    /**
     * The suit of this playing card
     */
    private Suit suit;

    /**
     * Get the suit of this card
     * @return - the suit of this card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Get the rank of this card
     * @return - the rank of this card
     */
    Rank getRank() {
        return rank;
    }

    /**
     * Create a new card with the given rank and suit
     *
     * @param rank - the rank of the card
     * @param suit - the suit of the card
     */
    Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Get the string representation of this card
     * @return the string representation of this card
     */
    public String toString() {
        return this.rank.toString() + this.suit.toString();
    }
}
