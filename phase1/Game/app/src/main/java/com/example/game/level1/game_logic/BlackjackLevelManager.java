package com.example.game.level1.game_logic;

import android.view.View;

import com.example.game.level1.activities.BlackjackPlayActivity;
import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.domain.BlackjackPlayerManager;
import com.example.game.level1.domain.Deck;

public class BlackjackLevelManager extends LevelManager {
    /**
     * Boolean representing whether it is the player's turn in the game
     */
    public static boolean playerTurn = false;

    /**
     * A PlayerManager object representing the user of the app
     */
    private BlackjackPlayerManager user;

    /**
     * A PlayerManager object representing the dealer in the game
     */
    private BlackjackPlayerManager dealer;

    /**
     * The deck being played with in this game
     */
    private Deck deck;

    /**
     * The InterfaceManager managing the interface
     */
    private InterfaceManager interfaceManager;

    /**
     * Create a new BlackjackLevelManager
     *
     * @param user             - the user of the app
     * @param dealer           - the dealer in the game
     * @param deck             - the deck to be played with
     * @param interfaceManager - the InterfaceManager to be used by this object
     */
    public BlackjackLevelManager(BlackjackPlayerManager user, BlackjackPlayerManager dealer, Deck deck, InterfaceManager interfaceManager) {
        this.user = user;
        this.dealer = dealer;
        this.deck = deck;
        this.interfaceManager = interfaceManager;
    }

    /**
     * Setup the game that this BlackjackLevelManager is going to be managing
     */
    @Override
    public void setup() {
        deck.shuffle();

        user.deal(deck.deal(2));
        dealer.deal(deck.deal(2));
    }

    /**
     * Tell the BlackjackLevelManager that the game is going to be played
     */
    @Override
    public void play() {
        playerTurn = true;
        interfaceManager.update();
    }

    /**
     * Handle a button click by the user
     *
     * @param view - the button that was clicked
     */
    @Override
    public void userButtonClick(View view) {
        if (view.getId() == BlackjackPlayActivity.HIT_BUTTON_ID) {
            if (playerTurn) {
                user.deal(deck.deal());
                if (user.computeBlackJackValue() > 21) {
                    interfaceManager.update();
                    ButtonManager.disableButton(BlackjackPlayActivity.HIT_BUTTON_ID);
                    ButtonManager.disableButton(BlackjackPlayActivity.STAND_BUTTON_ID);
                    endGame();
                    return;
                }
                interfaceManager.update();
            }
        } else if (view.getId() == BlackjackPlayActivity.STAND_BUTTON_ID) {
            ButtonManager.disableButton(BlackjackPlayActivity.HIT_BUTTON_ID);
            ButtonManager.disableButton(BlackjackPlayActivity.STAND_BUTTON_ID);
            endGame();
        }
    }

    /**
     * End the game. Calculate who won, update the interface, and tell this BlackjackLevelManager's
     * activity that the game is over
     */
    private void endGame() {
        playerTurn = false;
        interfaceManager.update();
        while (dealerHit()) {
            dealer.deal(deck.deal());
        }
        interfaceManager.update();

        int userHand = user.computeBlackJackValue();
        int dealerHand = dealer.computeBlackJackValue();

        if (userHand > 21) {
            activity.gameOver("You busted!", false);
        } else {
            if (dealerHand > 21) {
                activity.gameOver("You won! The dealer busted!", true);
            } else {
                if (dealerHand == userHand) {
                    activity.gameOver("You tied! Your hand was a " + userHand + " and the dealer's was a " + dealerHand, false);
                } else if (dealerHand < userHand) {
                    activity.gameOver("You won! Your hand was a " + userHand + " and the dealer's was a " + dealerHand, true);
                } else {
                    activity.gameOver("You lost! Your hand was a " + userHand + " and the dealer's was a " + dealerHand, false);
                }
            }
        }
    }

    private boolean dealerHit() {
        return dealer.computeBlackJackValue() <= 16;
    }
}
