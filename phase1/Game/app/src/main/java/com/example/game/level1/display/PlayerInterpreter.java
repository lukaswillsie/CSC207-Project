package com.example.game.level1.display;

import com.example.game.level1.display.PlayerHandView;
import com.example.game.level1.domain.Card;
import com.example.game.level1.domain.Hand;
import com.example.game.level1.domain.Player;

public class PlayerInterpreter {
    /**
     * The player whose hand this PlayerInterpreter is relaying to the interface
     */
    protected Player player;

    /**
     * The PlayerHandView that this PlayerInterpreter is using to
     * update the interface
     */
    protected PlayerHandView view;

    /**
     * Create a new PlayerInterpreter with the given instance variables
     *
     * @param player - the player this PlayerInterpreter will be interpreting
     * @param view   - the PlayerHandView this PlayerInterpreter will be using to
     *               update the interface
     */
    public PlayerInterpreter(Player player, PlayerHandView view) {
        this.player = player;
        this.view = view;
    }

    /**
     * Gets called when the player's hand has changed and the interface needs to be updated
     * <p>
     * Generates the new String representing the player's hand and tells view to update
     * the interface accordingly
     */
    public void updatePlayerHand() {
        view.updateView(this.playerHandStringRep());
    }

    public void updatePlayerHandHideFirstCard() {
        this.view.updateView(this.playerHandHideFirstCardStringRep());
    }

    private String playerHandHideFirstCardStringRep() {
        boolean first = true;
        Hand hand = this.player.getHand();
        StringBuilder handString = new StringBuilder();
        for (Card card : hand) {
            if (first) {
                handString.append("\u2588");
                handString.append("  ");

                first = false;
            } else {
                handString.append(card.toString());
                handString.append("  ");
            }

        }

        return handString.toString();
    }

    protected String playerHandStringRep() {
        Hand hand = player.getHand();
        StringBuilder handString = new StringBuilder();
        for (Card card : hand) {
            handString.append(card.toString());
            handString.append("  ");
        }

        return handString.toString();
    }
}
