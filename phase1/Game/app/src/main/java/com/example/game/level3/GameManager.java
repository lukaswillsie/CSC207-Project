package com.example.game.level3;

import java.util.ArrayList;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

/**
 * A GameManager class that handles all of the game logic.
 */
public class GameManager {
    // An array of the data for each turn.
    ArrayList<TurnData> data;

    // An array of the answer that the player is trying to guess.
    String[] answerArray;

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
}
