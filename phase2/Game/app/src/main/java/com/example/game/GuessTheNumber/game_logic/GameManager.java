package com.example.game.GuessTheNumber.game_logic;

import com.example.game.GuessTheNumber.domain.Game;

/**
 * This class handles all the logic of the whole GAME and all the rounds user want to play.
 */
public class GameManager {
    /**
     * The current game this game manager holds and User plays.
     */
    private Game game;
    /**
     * True iff there is at least one round left to play
     */
    private boolean keepPlaying;
    /**
     * #Rounds left to play for a user.
     */
    private int roundsToPlay;
    /**
     * Index of the current game user is playing.
     */
    private int currentRound;

    /**
     * Create a gameManager
     */
    public GameManager() {
        this.game = new Game();
        this.keepPlaying = true;
        this.roundsToPlay = 5;
        this.currentRound = 0;
    }

    /**
     * Creates a new game user is about to play.
     */
    public void startNewGame() {
        game = new Game();
    }

    /**
     * @return the current game user is playing.
     */
    public Game getCurrentGame() {
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
     * Reset the index of curent game.
     */
    public void resetCurrentRounds() {
        this.currentRound = 0;
    }
}
