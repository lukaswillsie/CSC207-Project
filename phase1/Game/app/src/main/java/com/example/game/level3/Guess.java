package com.example.game.level3;

import java.util.HashMap;

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

    /**
     * A method that returns the number of cows (the number of elements that were correctly guessed
     * and in the right position).
     */
    private int getCows() {

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
        HashMap<String, Integer> guessElements = new HashMap<>();
        HashMap<String, Integer> answerElements = new HashMap<>();

        for (int i = 0; i < this.guessSize; i++) {
            String guessElement = this.guessArray[i];
            String answerElement = this.answerArray[i];
            if (!guessElements.containsKey(guessElement)) {
                guessElements.put(guessElement, 1);
            } else {
                guessElements.put(guessElement, guessElements.get(guessElement) + 1);
            }
        }
    }

}
