package com.example.game.level3;

import java.util.HashMap;
import java.util.*;


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
     * Create a new Guess object. A precondition is that guessArray and answerArray must
     * have the same size.
     *
     * @param guessArray  An array of the guess made by the player.
     * @param answerArray¬ An array of the answer that the player is trying to guess.
     */
    public Guess(String[] guessArray, String[] answerArray) {
        this.guessArray = guessArray;
        this.answerArray = answerArray;
        this.guessSize = guessArray.length;
    }

    /**
     * A method that returns the number of cows (the number of elements that were correctly guessed
     * and in the right position).
     */
    int getCows() {

        int numberCows = 0;

        for (int i = 0; i < this.guessSize; i++) {
            if (this.guessArray[i] == this.answerArray[i]) {
                numberCows += 1;
            }
        }

        return numberCows;
    }

    /**
     * A method that returns a HashMap representation of an array where the keys are the elements in
     * the array and they values are the number of occurrences of this element in the the array.
     *
     * @param array The array to be processed.
     * @return The HashMap of element ot count pairs.
     */
    private HashMap<String, Integer> createMap(String[] array) {
        int arraySize = array.length;
        HashMap<String, Integer> arrayElements = new HashMap<>();


        for (int i = 0; i < arraySize; i++) {
            String element = array[i];
            if (!arrayElements.containsKey(element)) {
                arrayElements.put(element, 1);
            } else {
                arrayElements.put(element, arrayElements.get(element) + 1);
            }
        }

        return arrayElements;

    }

    /**
     * A method that returns the number of elements that were correctly guessed irrespective of
     * the order. Note that if the same element is guessed multiple times, then at most the number
     * of times this element appears in the answer is returned.
     */
    private int getCorrectElements() {
        HashMap<String, Integer> guessElements = createMap(this.guessArray);
        HashMap<String, Integer> answerElements = createMap(this.answerArray);

        int correctCounter = 0;
        for (Map.Entry mapElement : answerElements.entrySet()) {
            String key = (String) mapElement.getKey();

            if (guessElements.containsKey(key)) {
                correctCounter += Math.min(guessElements.get(key), answerElements.get(key));
            }
        }

        return correctCounter;

    }

    /**
     * A method that returns the number of bulls (the number of elements that were correctly guessed
     * but in the wrong spot).
     *
     * @return The number of correct elements, but in the wrong spot.
     */
    int getBulls() {

        //  The number of cows is the total number of correct guessed regardless of their spots
        //  minus the number of correct guesses in the right spots.
        return getCorrectElements() - getCows();

    }

}