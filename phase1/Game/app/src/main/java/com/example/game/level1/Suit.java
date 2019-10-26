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
                return "\u2665";
            case CLUBS:
                return "\u2663";
            case DIAMONDS:
                return "\u2666";
            default:
                return "";
        }
    }
}
