package com.example.game.GuessTheNumber.game_logic;

import com.example.game.GuessTheNumber.domain.GuessTheNumberRound;

/**
 * This class handles all the logic of the whole GAME and all the rounds user want to play.
 */
public class GameManager {
    /**
     * The current game this game manager holds and User plays.
     */
    private GuessTheNumberRound game;
    /**
     * True iff there is at least one round left to play
     */
    private boolean keepPlaying;
    /**
     * Rounds left to play for a user.
     */
    private int roundsToPlay;
    /**
     * Index of the current game user is playing.
     */
    private int currentRound;

    /**
     * True iff on single mode or if it is the first player's turn on multiplayer mode.
     */
    private boolean isFirstPlayersTurn;

    /**
     * Create a gameManager
     */
    public GameManager() {
        resetGameManager();
        this.roundsToPlay = 5;
    }

    /**
     * Reset the GameManager values.
     */
    public void resetGameManager() {
        startNewGame();
        this.keepPlaying = true;
        this.currentRound = 0;
        this.isFirstPlayersTurn = true;
    }

    /**
     * Creates a new game user is about to play.
     */
    public void startNewGame() {
        game = new GuessTheNumberRound();
    }

    /**
     * @return the current game user is playing.
     */
    public GuessTheNumberRound getCurrentGame() {
        return this.game;
    }

    public boolean getKeepPlaying() {
        return this.keepPlaying;
    }

    public void setRoundsToPlay(int rounds) {
        this.roundsToPlay = rounds;
    }

    /**
     * Updates the number of rounds are left to play.
     */
    public void checkRounds() {
        this.currentRound++;
        this.keepPlaying = this.currentRound != this.roundsToPlay;
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    public int getRoundsToPlay() {
        return this.roundsToPlay;
    }

    /**
     * Reset the index of current game.
     */
    public void resetCurrentRounds() {
        this.currentRound = 0;
    }


    /**
     * Returns true if the user is currently on multiplayer mode and false otherwise.
     * <p>
     * /**
     * Return true if it is currently on multiplayer mode and it is the first user's turn, and
     * false otherwise.
     */
    public boolean getIsFirstPlayersTurn() {
        return this.isFirstPlayersTurn;
    }

    public void changeIsFirstPlayersTurn() {
        this.isFirstPlayersTurn = !this.isFirstPlayersTurn;
    }


}
