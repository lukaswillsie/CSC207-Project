package com.example.game.CowsBullsGame.domain;


/**
 * A guessArray object that stores the user's guessArray
 */
public class Guess {

    //String array for the guessArray
    private String[] guessArray;

    /**
     * Constructor call of the Guess object
     *
     * @param guess
     */
    public Guess(String guess) {

        String[] guessArrayTemp = new String[guess.length()];
        for (int i = 0; i < guess.length(); i++) {
            guessArrayTemp[i] = String.valueOf(guess.charAt(i)).toLowerCase();

            this.guessArray = guessArrayTemp;
        }
    }


    /**
     * Getter for guessArray
     * @return - returns string object for guessArray
     */
    public String[] getGuessArray() {
        return guessArray;
    }
}
