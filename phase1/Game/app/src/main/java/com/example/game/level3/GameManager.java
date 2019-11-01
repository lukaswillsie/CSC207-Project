package com.example.game.level3;

import java.util.ArrayList;

/**
 * A GameManager class that handles all of the game logic.
 */
public class GameManager {
    // An array of the data for each turn.
    ArrayList<TurnData> data;

    // An array of the answer that the player is trying to guess.
    String[] answerArray;

    // An Guess object to store the current guess.
    Guess guess;

    /**
     * A constructor for the GameManager class.
     *
     * @param answerSize The size of the guess / answer.
     */
    GameManager(int answerSize) {
        String[] alphabet = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        // Generate a random string given the alphabet with size answerSize.
        for (int i = 0; i < answerSize; i++) {

            // Generate a random integer from 0 to answerSize - 1 with equal probabilities.
            int rand = (int) (Math.random());

            this.answerArray[i] = alphabet[rand];

        }
    }

    /**
     * A method that sets the current guess.
     *
     * @param guessArray The new guess.
     */
    public void setGuess(String[] guessArray) {
        // Double check that aliasing is okay. Otherwise make copy.
        this.guess = new Guess(guessArray, this.answerArray);
    }

    /**
     * A method that returns the number of cows and bulls for the current guess.
     *
     * @return An integer array where the first element is the number of cows and the second element
     * is the number of bulls.
     */
    public int[] getResults() {
        return new int[]{guess.getCows(), guess.getBulls()};
    }

}
