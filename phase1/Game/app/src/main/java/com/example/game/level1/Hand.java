package com.example.game.level1;

import java.util.ArrayList;

import static com.example.game.level1.Rank.ACE;

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

    public int computeBlackJackValue(){
        ArrayList<Card> aces = new ArrayList<>();
        int value = 0;
        Rank rank;
        for(Card card : hand){
            rank = card.getRank();
            if(rank == ACE){
                aces.add(card);
            }
            else{
                if(2 <= rank.getValue() && rank.getValue() <= 10){
                    value += rank.getValue();
                }
                else {
                    value += 10;
                }
            }
        }

        for(Card ace : aces){
            if(value + 11 <= 21){
                value += 11;
            }
            else{
                value += 1;
            }
        }

        return value;
    }
}
