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
    private int numOfGuess;
    /**
     * Specify if game is finished
     */
    private boolean finished;
    /**
     * Total number of point that user receives for the game.
     */
    private int points;

    /**
     * Number to guess.
     */
    private int number;
    /**
     * stores the user of this game.
     */
    User user;
    /**
     * Create a new Game for User.
     */
    Game(){
        this.numOfGuess = 0;
        this.finished = false;
        this.points = 0;
        this.number = (int)(Math.random() * 10 + 1); //!!!!! CHANGE NEEDED.
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
    boolean checkTheRightGuess(int guess){
        return this.number == guess;
    }

    /**
    Precondition for check the guess is the guess is not equal to the actual number.
     Return true iff the guess if less than the number we are seeking.
     */
    boolean checkGuess(int guess) {
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

    public int getNumber() {
        return number;
    }

    public int getPoints(){
        return this.points;
    }

    public int getNumOfGuess(){
        return this.numOfGuess;
    }

    public boolean isFinished() {return this.finished;}

    public void setIsFinished() {
        this.finished = true;
    }
}
