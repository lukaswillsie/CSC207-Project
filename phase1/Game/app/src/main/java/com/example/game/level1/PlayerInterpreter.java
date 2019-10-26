package com.example.game.level1;

public class PlayerInterpreter {
    /**
     * The player whose hand this PlayerInterpreter is relaying to the interface
     */
    private Player player;

    /**
     * The PlayerHandView that this PlayerInterpreter is using to
     * update the interface
     */
    private PlayerHandView view;

    /**
     * Create a new PlayerInterpreter with the given instance variables
     * @param player - the player this PlayerInterpreter will be interpreting
     * @param view - the PlayerHandView this PlayerInterpreter will be using to
     *               update the interface
     */
    public PlayerInterpreter(Player player, PlayerHandView view){
        this.player = player;
        this.view = view;
    }

    /**
     * Gets called when the player's hand has changed and the interface needs to be updated
     *
     * Generates the new String representing the player's hand and tells view to update
     * the interface accordingly
     */
    public void updatePlayerHand(){
        Hand hand = player.getHand();
        StringBuilder handString = new StringBuilder();
        for(Card card : hand){
            handString.append(card.toString());
        }

        view.updateView(handString.toString());
    }
}
