package com.example.game.level2;
import java.util.ArrayList;

public class GameManager {
    /**
     * list of all games that have been played
     */
    ArrayList<Game> gameList;
    /**
     * Leader board keeps track of top three players.
     */
    int[] leaderBoard = new int[3];
    /**
     * Rules for the game.
     */
    String rules;

    /**
     * Create a gameManager
     */
    public GameManager(){
       this.gameList = new ArrayList<>();
       this.rules = "";
    }

    // call this class whenever a new GTN game is about to be played
    public void startNewGame() {
        Game newGame = new Game();
    }

}
