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

    /**
     * Create a gameManager
     */
    public GameManager() {
        this.game = new Game();
    }

    // call this class whenever a new GTN game is about to be played
    public void startNewGame() {
        game = new Game();
    }

    public Game getCurrentGame() {
        return this.game;
    }

}
