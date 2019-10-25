package com.example.game.level1;

public class Card {
    public enum Suit {
        SPADES,
        HEARTS,
        CLUBS,
        DIAMONDS
    }

    public enum Rank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
    
    /**
     * The suit of this playing card
     */
    private Suit suit;

    /**
     * The rank of this playing card
     */
    private Rank rank;

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }


    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
}
