package com.example.game.CowsBullsGame.domain;

import java.util.Arrays;
import java.util.List;

// An enum defining what alphabet the answer object can take on.
enum Alphabet {LETTERS, DIGITS, DIGITS_LETTERS, DIGITS_LETTERS_SYMBOLS};

/**
 * Class for the answer to the cows and bulls game.
 */
public class Answer {

    // The array storing the answer string.
    private String[] answerArray;

    // The valid alphabet for this game.
    private List<String> alphabetList;

    /**
     * Constructor call for the Answer object.
     *
     * @param answerSize       The size of the answer.
     * @param alphabetSelector An enum to define the possible strings that can appear in the answer.
     */
    public Answer(int answerSize, Alphabet alphabetSelector) {
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
            // Generate a random integer from 0 to alphabet.length - 1 with equal probabilities.
            int rand = (int) (Math.random() * alphabet.length);
            this.answerArray[i] = alphabet[rand];
            System.out.println(answerArray[i]);
        }

        alphabetList = Arrays.asList(alphabet);
    }

    /**
     * A method that returns the answer array for this answer object.
     *
     * @return The answer array for tis answer object.
     */
    public String[] getAnswerArray() {
        return answerArray;
    }

    /**
     * A helper method to concatenate two arrays.
     *
     * @param array1 The first array to concatenate.
     * @param array2 The second array to concatenate.
     * @return The concatenation of array1 and array2.
     */
    private String[] concatenateArrays(String[] array1, String[] array2) {
        String[] concat = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, concat, 0, array1.length);
        System.arraycopy(array2, 0, concat, array1.length, array2.length);

        return concat;
    }


    /**
     * A method that returns whether the guess only contains strings from the alphabet.
     *
     * @param guess The string to check.
     * @return True iff all strings in guess are in the alphabet for this answer.
     */
    public boolean checkValidGuess(String guess) {
        for (int i = 0; i < guess.length(); i++) {
            if (!checkInAlphabet(String.valueOf(guess.charAt(i)).toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * A helper method that determines if a string is in the alphabet for this answer.
     *
     * @param string The string to check for in the alphabet.
     * @return True iff string is in the alphabet for this answer object.
     */
    private boolean checkInAlphabet(String string) {
        return alphabetList.contains(string);
    }
}
