package com.example.game.GuessTheNumber.game_logic;

import com.example.game.GuessTheNumber.domain.Game;
import com.example.game.data.GameData;
import com.example.game.data.MultiplayerGameData;
import com.example.game.data.Setting;
import com.example.game.services.stats.StatsManager;

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

    private boolean multiplayerMode;

    private boolean multiplayerKeepPlaying;

    /**
     * Create a gameManager
     */
    public GameManager() {
        resetGameManager();
        this.roundsToPlay = 5;
    }

    public void resetGameManager() {
        startNewGame();
        this.keepPlaying = true;
        this.currentRound = 0;
        this.multiplayerKeepPlaying = true;

        if (GameData.MULTIPLAYER) {
            this.multiplayerMode = true;
        } else {
            this.multiplayerMode = false;
        }
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
     * Reset the index of current game.
     */
    public void resetCurrentRounds() {
        this.currentRound = 0;
    }


    /**
     * Returns true if the user is currently on multiplayer mode and false otherwise.
     */
    public boolean getMultiplayerMode() {
        return this.multiplayerMode;
    }

    public void setMultiplayerMode(boolean b) {
        this.multiplayerMode = b;
    }

    /**
     * Return true if it is currently on multiplayer mode and it is the first user's turn, and
     * false otherwise.
     */
    public boolean getMultiplayerKeepPlaying() {
        return this.multiplayerKeepPlaying;
    }

    public void changeMultiplayerKeepPlaying() {
        this.multiplayerKeepPlaying = !this.multiplayerKeepPlaying;
    }


}
