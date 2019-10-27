package com.example.game.level1.domain;

import java.util.ArrayList;

import static com.example.game.level1.domain.Rank.ACE;

public class BlackjackPlayerManager {
    private Player player;

    public BlackjackPlayerManager(Player player){
        this.player = player;
    }

    public void deal(Card card){
        player.getHand().addCard(card);
    }

    public void deal(Card[] cards){
        for(Card card : cards){
            deal(card);
        }
    }

    public int computeBlackJackValue() {
        Hand hand = player.getHand();
        ArrayList<Card> aces = new ArrayList<>();
        int value = 0;
        Rank rank;
        for (Card card : hand) {
            rank = card.getRank();
            if (rank == ACE) {
                aces.add(card);
            } else {
                if (2 <= rank.getValue() && rank.getValue() <= 10) {
                    value += rank.getValue();
                } else {
                    value += 10;
                }
            }
        }

        for (Card ace : aces) {
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }

        return value;
    }
}
