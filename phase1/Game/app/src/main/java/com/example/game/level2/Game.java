package com.example.game.level2;

import java.lang.Math;

public class Game {
    /**
     * Name of the person, playing the game.
     */
    String username;
    /**
     * Number of guesses, that this user has used.
     */
    int numOfGuess;
    /**
     * Specify if game is finished
     */
    boolean finished;
    /**
     * Total number of point that user receives for the game.
     */
    int points;
    /**
     * Number to guess.
     */
    int number;
    /**
     * stores the user of this game.
     */
    User user;
    /**
     * Create a new Game for User.
     */
    public Game(){
        this.numOfGuess = 0;
        this.finished = false;
        this.points = 0;
        this.number = (int)(Math.random() * 50 + 1); //!!!!! CHANGE NEEDED.
    }

    /**
     * Finish the game.
     */
    public void finishTheGame() {
            this.finished = false;
            this.numOfGuess++;
    }

    /**
     * Check if the guess is the exact number the the seek.
     */
    public boolean checkTheRightGuess(int guess){
        return this.number == guess;
    }

    /**
    Precondition for check the guess is the guess is not equal to the actual number.
     Return true iff the guess if less than the number we are seeking.
     */
    public boolean checkGuess(int guess) {
        this.updateStats(guess);
        return this.number < guess;
    }

    /**
     * Update statistics for the game: points and number of guesses.
     */
    private void updateStats(int guess) {
        this.numOfGuess++;
        this.points += Math.abs(this.number - guess) * this.numOfGuess;
    }

}
