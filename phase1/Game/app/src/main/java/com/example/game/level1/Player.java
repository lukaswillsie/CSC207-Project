package com.example.game.level1;

public class Player {
    /**
     * Get this player's hand
     * @return this player's hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * This player's hand
     */
    private Hand hand;

    /**
     * Add the given card to this player's hand
     * @param card - the card to add to this player's hand
     */
    void deal(Card card){
        this.hand.addCard(card);
    }
}
