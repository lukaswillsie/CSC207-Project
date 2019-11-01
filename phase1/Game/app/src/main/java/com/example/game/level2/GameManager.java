package com.example.game.level2;

public class GameManager {
    /**
     * The current game this game manager holds.
     */
    private Game game;
    /**
     * Leader board keeps track of top three players.
     */
    int[] leaderBoard = new int[3];

    private boolean keepPlaying;

    private int roundsToPlay;

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

    // call this class whenever a new GTN game is about to be played
    public void startNewGame() {
        game = new Game();
    }

    public Game getCurrentGame() {
        return this.game;
    }

    public boolean getKeepPlaying() {
        return this.keepPlaying;
    }

    public void setRoundsToPlay(int rounds) {
        this.roundsToPlay = rounds;
    }

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
}
