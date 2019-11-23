package com.example.game.BlackjackGame.game_logic;

import com.example.game.BlackjackGame.activities.BlackjackPlayPage;
import com.example.game.BlackjackGame.domain.BlackjackPlayerManager;
import com.example.game.BlackjackGame.domain.Deck;

/**
 * Manages a game of Blackjack with a user and a dealer
 */
public class BlackjackLevelManager {
    /**
     * Boolean representing whether it is the player's turn in the game
     */
    static boolean playerTurn = false;

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
     * The BlackjackPlayPage that created this instance of BlackjackLevelManager
     */
    private BlackjackPlayPage callingActivity;

    /**
     * The maximum number of hands this BlackjackLevelManager will play
     */
    private int numHands = -1;

    /**
     * The number of hands played so far
     */
    private int numHandsPlayed;

    // TODO: Figure out how to shorten this constructor, maybe using setters instead of constructor

    /**
     * Create a new BlackjackLevelManager
     *
     * @param user             - the user of the app
     * @param dealer           - the dealer in the game
     * @param deck             - the deck to be played with
     * @param interfaceManager - the InterfaceManager to be used by this object
     */
    public BlackjackLevelManager(BlackjackPlayerManager user, BlackjackPlayerManager dealer, Deck deck, InterfaceManager interfaceManager, BlackjackPlayPage callingActivity) {
        this.user = user;
        this.dealer = dealer;
        this.deck = deck;
        this.interfaceManager = interfaceManager;
        this.callingActivity = callingActivity;
    }

    /**
     * Set the number of hands to be played by this BlackjackLevelManager.
     * <p>
     * Once the field has been set it cannot be changed.
     * <p>
     * Precondition: numHands is a positive integer
     *
     * @param numHands - the number of hands of Blackjack to be played by this BlackjackLevelManager
     */
    public void setNumHands(int numHands) {
        if (this.numHands == -1) {
            this.numHands = numHands;
        }
    }

    /**
     * Setup the game that this BlackjackLevelManager is going to be managing
     */
    public void setup() {
        deck.shuffle();

        user.deal(deck.deal(2));
        dealer.deal(deck.deal(2));
    }

    /**
     * Tell the BlackjackLevelManager that the game is going to be played
     */
    public void play() {
        playerTurn = true;
        interfaceManager.update();
    }

    /**
     * Get this BlackjackLevelManager ready to play another hand
     */
    public void playAgain() {
        deck = new Deck();
        user.newHand();
        dealer.newHand();
        setup();
        play();
    }

    /**
     * Return whether or not this BlackjackLevelManager is ready to play another round
     */
    public boolean anotherRound() {
        return numHandsPlayed < numHands;
    }

    /**
     * Tells this object that the player requested a hit
     */
    public void playerHit() {
        if (playerTurn) {
            user.deal(deck.deal());
            if (user.computeBlackJackValue() > 21) {
                interfaceManager.update();
                endGame();
                return;
            }
            interfaceManager.update();
        }
    }

    /**
     * Tells this object that the player stood
     */
    public void playerStand() {
        endGame();
    }

    // TODO: Change "game" to "round" or "hand"  here and elsewhere to make it more clear that this is the end of a single round, not the whole game

    /**
     * End the game. Calculate who won, record that another hand has been played, update the interface,
     * and tell this BlackjackLevelManager's activity that the game is over
     */
    private void endGame() {
        numHandsPlayed++;
        playerTurn = false;
        interfaceManager.update();
        while (dealerHit()) {
            dealer.deal(deck.deal());
        }
        interfaceManager.update();

        int userHand = user.computeBlackJackValue();
        int dealerHand = dealer.computeBlackJackValue();

        if (userHand > 21) {
            callingActivity.gameOver("You busted!", false);
        } else {
            if (dealerHand > 21) {
                callingActivity.gameOver("You won! The dealer busted!", true);
            } else {
                if (dealerHand == userHand) {
                    callingActivity.gameOver("You tied! Your hand was a " + userHand + " and the dealer's was a " + dealerHand, false);
                } else if (dealerHand < userHand) {
                    callingActivity.gameOver("You won! Your hand was a " + userHand + " and the dealer's was a " + dealerHand, true);
                } else {
                    callingActivity.gameOver("You lost! Your hand was a " + userHand + " and the dealer's was a " + dealerHand, false);
                }
            }
        }
    }

    /**
     * Compute whether or not the dealer should take another card
     *
     * @return true if the dealer's hand total is less than or equal to 16
     * false otherwise (Casino rules)
     */
    private boolean dealerHit() {
        return dealer.computeBlackJackValue() <= 16;
    }
}
