package com.example.game.level1.game_logic;

import android.util.Log;
import android.view.View;

import com.example.game.R;
import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.domain.Dealer;
import com.example.game.level1.domain.Deck;
import com.example.game.level1.domain.Player;

public class BlackjackLevelManager extends LevelManager {
    private static final int HIT_BUTTON_ID = R.id.hitButton;
    private static final int STAND_BUTTON_ID = R.id.standButton;
    public static boolean playerTurn = false;

    private Player user;
    private Dealer dealer;
    private Deck deck;
    private InterfaceManager interfaceManager;
    private ButtonManager buttonManager;

    public BlackjackLevelManager(Player user, Dealer dealer, Deck deck, InterfaceManager interfaceManager, ButtonManager buttonManager) {
        this.user = user;
        this.dealer = dealer;
        this.deck = deck;
        this.interfaceManager = interfaceManager;
        this.buttonManager = buttonManager;
    }

    @Override
    public void setup() {
        deck.shuffle();

        user.deal(deck.deal(2));
        dealer.deal(deck.deal(2));
    }

    @Override
    public void play() {
        playerTurn = true;
        interfaceManager.update();
    }

    @Override
    public void userButtonClick(View view) {
        if (view.getId() == HIT_BUTTON_ID) {
            if (playerTurn) {
                user.deal(deck.deal());
                if(user.getHand().computeBlackJackValue() > 21){
                    interfaceManager.update();
                    endGame();
                    return;
                }
                interfaceManager.update();
            }
        } else if (view.getId() == STAND_BUTTON_ID) {
            buttonManager.disableButton(HIT_BUTTON_ID);
            buttonManager.disableButton(STAND_BUTTON_ID);
            endGame();
        }
    }

    private void endGame(){
        interfaceManager.update();
        playerTurn = false;
        interfaceManager.update();
        while (dealer.getMove().equals(Dealer.HIT_KEY)) {
            dealer.deal(deck.deal());
            interfaceManager.update();
        }

        int userHand = user.getHand().computeBlackJackValue();
        int dealerHand = dealer.getHand().computeBlackJackValue();

        if(userHand > 21){
            activity.gameOver("You busted!");
        }
        else{
            if(dealerHand > 21){
                activity.gameOver("You won! The dealer busted!");
            }
            else{
                if(dealerHand == userHand){
                    activity.gameOver("You tied! Your hand was a " + userHand + " and the dealer's was a " + dealerHand);
                }
                else if(dealerHand < userHand){
                    activity.gameOver("You won! Your hand was a " + userHand + " and the dealer's was a " + dealerHand);
                }
                else{
                    activity.gameOver("You lost! Your hand was a " + userHand + " and the dealer's was a " + dealerHand);
                }
            }
        }
    }
}
