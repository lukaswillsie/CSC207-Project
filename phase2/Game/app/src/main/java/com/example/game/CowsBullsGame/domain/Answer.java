package com.example.game.CowsBullsGame.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Class for the answer to the game
 */
public class Answer {

    //String of the answer
    private String[] answerArray;

    /**
     * An enum defining what Alphabets the answer objects can take on.
     */
    enum Game {LETTERS, DIGITS, DIGITS_LETTERS, DIGITS_LETTERS_SYMBOLS}

    // The valid alphabet for this game.
    private List<String> alphabetList;

    /**
     * Constructor call for the Answer object
     *
     * @param answerSize       The size of the answer.
     * @param alphabetSelector The possible strings that can appear in the answer.
     */
    public Answer(int answerSize, Game alphabetSelector) {
        String[] alphabet;
        this.answerArray = new String[answerSize];

        String[] digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] symbols = new String[]{"!", "@", "#", "_", "-", "+", "=", "(", ")", "*", "&", "%"};

        switch (alphabetSelector) {
            case DIGITS:
                alphabet = digits;
                break;
            case DIGITS_LETTERS:
                alphabet = concatenateArrays(digits, letters);
                break;
            case DIGITS_LETTERS_SYMBOLS:
                alphabet = concatenateArrays(digits, concatenateArrays(letters, symbols));
                break;
            case LETTERS:
            default:
                alphabet = letters;
        }

        for (int i = 0; i < answerSize; i++) {
            // Generate a random integer from 0 to answerSize - 1 with equal probabilities.
            int rand = (int) (Math.random() * alphabet.length);
            this.answerArray[i] = alphabet[rand];
            System.out.println(answerArray[i]);
        }

        alphabetList = Arrays.asList(alphabet);
    }

    public String[] getAnswerArray() {
        return answerArray;
    }

    private String[] concatenateArrays(String[] array1, String[] array2) {
        String[] concat = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, concat, 0, array1.length);
        System.arraycopy(array2, 0, concat, array1.length, array2.length);

        return concat;
    }

    public boolean checkInAlphabet(String string) {
        return alphabetList.contains(string);
    }
}
