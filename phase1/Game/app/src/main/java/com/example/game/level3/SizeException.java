package com.example.game.level3;

/**
 * An exception class for when the guessArray and answerArray do not have the same sizes.
 */
public class SizeException extends Exception {
    public SizeException() {
        super("The guess and answer do not have the same sizes.");
    }
}

