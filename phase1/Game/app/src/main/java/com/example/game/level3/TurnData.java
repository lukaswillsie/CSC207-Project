package com.example.game.level3;

/**
 * A class that deals with the data for one turn of the game.
 */
public class TurnData {

    public String[] guessArray;
    public int numberCows;
    public int numberBulls;

    /**
     * Create a TurnData object. A precdndition is that guessArray and answerArray must have the
     * same sizes.
     *
     * @param guessArray  An array of the elements guessed by the player.
     * @param answerArray An array of the elements for the correct answer.
     */
    public TurnData(String[] guessArray, String[] answerArray) {

        Guess guess = new Guess(guessArray, answerArray);
        this.guessArray = guessArray;
        this.numberBulls = guess.getBulls();
        this.numberCows = guess.getCows();
    }


}
