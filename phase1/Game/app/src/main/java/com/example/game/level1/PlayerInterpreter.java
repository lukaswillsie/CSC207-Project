package com.example.game.level1;

public class PlayerInterpreter {
    private Player player;
    private PlayerHandView view;

    public PlayerInterpreter(Player player, PlayerHandView view){
        this.player = player;
        this.view = view;
    }

    public void updatePlayerHand(){
        Hand hand = player.getHand();
        String handString = "";
        for(Card card : hand){
            handString += card.toString();
        }

        view.updateView(handString);
    }
}
