package com.example.game.level1;

public enum Suit {
    SPADES,
    HEARTS,
    CLUBS,
    DIAMONDS;

    public String toString(){
        switch(this){
            case SPADES:
                return "\u2660";
            case HEARTS:
                return "\u2661";
            case CLUBS:
                return "\u2663";
            case DIAMONDS:
                return "\u2662";
            default:
                return "";
        }
    }
}
