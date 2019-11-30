package com.example.game.CowsBullsGame.domain;

/**
 * Class for the answer to the game
 */
public class Answer {

    //String of the answer
    private String[] answerArray;


    /**
     * Constructor call for the Answer object
     *
     * @param answerSize       The size of the answer.
     * @param alphabetSelector The possible strings that can appear in the answer.
     */
    public Answer(int answerSize, int alphabetSelector) {
        String[] alphabet;
        this.answerArray = new String[answerSize];

        if (alphabetSelector == 0) {
            alphabet = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        } else {
            alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                    "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        }

        for (int i = 0; i < answerSize; i++) {
            // Generate a random integer from 0 to answerSize - 1 with equal probabilities.
            int rand = (int) (Math.random() * alphabet.length);
            this.answerArray[i] = alphabet[rand];
            System.out.println(answerArray[i]);
        }
    }

    public String[] getAnswerArray() {
        return answerArray;
    }


}
