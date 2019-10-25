package com.example.game.level1;

public class Card {
    /**
     * The rank of this playing card
     */
    private Rank rank;

    /**
     * The suit of this playing card
     */
    private Suit suit;

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    /**
     * Create a new card with the given rank and suit
     *
     * @param rank - the rank of the card
     * @param suit - the suit of the card
     */
    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }
}
