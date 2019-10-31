package com.example.game.level3;

/**
 * A class that deals with a guess that a player makes.
 */
public class Guess {

    // The number of characters in a guess.
    int guessSize;

    // An array where each entry is the corresponding string guessed.
    String[] guessArray;

    // An array where each entry is the corresponding string from the correct answer.
    String[] answerArray;

    /**
     * @param guessArray  An array of the guess made by the player.
     * @param answerArray An array of the answer that the player is trying to guess.
     * @throws SizeException An exception for when the guess and answer are of different sizes.
     */
    public Guess(String[] guessArray, String[] answerArray) throws SizeException {
        int guessArraySize = guessArray.length;
        int answerArraySize = answerArray.length;

        if (guessArraySize != answerArraySize) {
            throw new SizeException();
        }
        this.guessArray = guessArray;
        this.answerArray = answerArray;
        this.guessSize = guessArraySize;
    }

}
