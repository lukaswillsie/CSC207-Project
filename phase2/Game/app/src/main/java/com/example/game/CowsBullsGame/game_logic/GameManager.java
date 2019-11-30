package com.example.game.CowsBullsGame.game_logic;

import com.example.game.CowsBullsGame.domain.Answer;
import com.example.game.CowsBullsGame.domain.Guess;

import java.util.ArrayList;

/**
 * A GameManager class that handles all of the game logic.
 */
public class GameManager {
    // An array of the data for each turn.
    private ArrayList<TurnData> data = new ArrayList<>();

    // An array of the answer that the player is trying to guess.
    private Answer answerArray;

    // A TurnData object to store the information for the current turn.
    private TurnData turnData;

    //The size of the answerArray
    private int answerSize;

    /**
     * A constructor for the GameManager class.
     *
     * @param answerSize       The size of the guess / answer.
     * @param alphabetSelector The possible strings that can appear in the answer / guess.
     */
    public GameManager(int answerSize, int alphabetSelector) {
        answerArray = new Answer(answerSize, alphabetSelector);
        this.answerSize = answerSize;
    }

    /**
     * A method that sets the current guess.
     *
     * @param guessArray The new guess.
     */
    public void setGuess(Guess guessArray) {
        this.turnData = new TurnData(guessArray, this.answerArray);
        this.data.add(this.turnData);
    }

    /**
     * A method that returns the number of cows and bulls for the current guess.
     *
     * @return An integer array where the first element is the number of cows and the second element
     * is the number of bulls.
     */
    public int[] getResults() {
        return turnData.getResults();
    }

    /**
     * A method that returns all of the data / statistics collected so far in level 3.
     *
     * @return An array of TurnData objects which store the data for each turn.
     */
    public ArrayList<TurnData> getStatistics() {
        return this.data;
    }

    /**
     * A method that returns true if the user guessed correctly, false otherwise
     *
     * @return Boolean indicating whether user has made the right guess
     */
    public boolean gameEnd() {
        return (getResults()[1] == answerSize);
    }

    /**
     * A method that returns true if currentGuess is a valid guess to make
     *
     * @param currentGuess The currentGuess of user
     * @return Boolean of whether the currentGuess by user is valid
     */
    public boolean checkGuess(String currentGuess) {
        return (currentGuess.length() == answerSize & !currentGuess.equals("null"));
    }

    public int getAnswerSize() {
        return answerSize;
    }
}