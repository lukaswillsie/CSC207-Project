package com.example.game.level2;

public class Game {
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
     * Create a new Game for a user.
     */
    private int range = 5;
    Game() {
        this.numOfGuess = 0;
        this.finished = false;
        this.points = 0;
        this.number = (int) (Math.random() * range + 1); //!!!!! CHANGE NEEDED.
    }

    /**
     * Finish the game.
     */
    public void finishTheGame(int guess) {
        this.finished = false;
        this.updateStats(guess);
    }

    /**
     * Check if the guess is the exact number the the seek.
     */
    boolean checkTheRightGuess(int guess) {
        return this.number == guess;
    }

    /**
     * Precondition for check the guess is the guess is not equal to the actual number.
     * Return true iff the guess if less than the number we are seeking.
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

    public int getPoints() {
        return this.points;
    }

    public int getNumOfGuess() {
        return this.numOfGuess;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void setIsFinished() {
        this.finished = true;
    }
}
