package com.example.game.services.scoreboard;

import android.util.Log;
import android.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is an implementation of ScoreboardRepository that stores highscore data in a file, with
 * the following format:
 * name1,score1
 * name2,score2
 * name3,score3
 * .
 * .
 * .
 * etc.
 * <p>
 * The lines are sorted in decreasing order of score, with the highest score on the first line of the
 * file
 * <p>
 * The File object this ScoreboardFileManager will be working with will be given to the object at
 * object creation via the setFile(File file) method
 */
class ScoreboardFileManager implements ScoreboardRepository {
    /**
     * The String this class will use to log things to the console
     */
    private static final String TAG = "com.example.game.ScoreboardFileManager.java";

    /**
     * The File that this object is writing high score data to and getting it from
     */
    private File highscoreFile;

    /**
     * THIS METHOD MUST BE CALLED BEFORE THE OBJECT CAN BE USED
     * <p>
     * Tell this object what file the high scores are stored in. File must be in simple .csv format
     * That is, high scores must be stored in the following form:
     * name1,score1
     * name2,score2
     * name3,score3
     * .
     * .
     * .
     * etc.
     * Precondition: Entries MUST be sorted in non-decreasing order of score
     *
     * @param file - the file where the high scores are
     */
    void setFile(File file) {
        highscoreFile = file;
    }

    /**
     * Record that a player with given name has achieved the given score
     * <p>
     * Implements method in ScoreboardRepository
     *
     * @param name  - the name of the player
     * @param score - the player's score
     */
    @Override
    public void addHighScore(String name, int score) {
        if (!validName(name)) {
            return;
        }

        FileOutputStream highscoreStream = null;
        List<Pair<String, Integer>> pairs;
        try {
            pairs = getPairsFromLines(readLines());
            if (pairs == null) {
                return;
            }

            boolean added = false;
            int i = 0;
            // Insert the new name,score pair into the list of pairs in its proper place with respect to ordering
            for (Pair<String, Integer> pair : pairs) {
                if (score > pair.second) {
                    pairs.add(i, new Pair<>(name, score));
                    added = true;
                    break;
                }
                i++;
            }

            // If the new score hasn't been added by the end of the for loop, insert it at the end
            if (!added) {
                pairs.add(new Pair<>(name, score));
            }

            highscoreStream = new FileOutputStream(highscoreFile);

            for (Pair<String, Integer> pair : pairs) {
                highscoreStream.write((pair.first + "," + pair.second + "\n").getBytes());
            }

            highscoreStream.close();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Couldn't open highscoreFile " + highscoreFile.getName());
            try {
                if (highscoreStream != null) {
                    highscoreStream.close();
                }
            } catch (IOException ex) {
                Log.e(TAG, "Couldn't close highscoreStream");
            }
        } catch (IOException e) {
            Log.e(TAG, "Couldn't write to highscoreFile " + highscoreFile.getName());
            try {
                highscoreStream.close();
            } catch (IOException ex) {
                Log.e(TAG, "Couldn't close highscoreStream");
            }
        }
    }

    /**
     * Retrieves the *numberHighScores* highest scores, or all the high scores if there are fewer
     * than *numberHighScores* in total, and returns them as an array of pairs of the form
     * [name, score], in increasing order of score.
     * <p>
     * Implements the method in ScoreboardRepository
     * <p>
     * Precondition: numberHighScores > 0
     *
     * @param numberHighScores - the number of highScores to fetch
     * @return the *numberHighScores* highest scores, or all the high scores if numberHighScores
     * exceeds the total
     */
    @Override
    public List<Pair<String, Integer>> getHighScores(int numberHighScores) {
        List<String> lines;
        try {
            lines = readLines(numberHighScores);
            Log.i("Scoreboard Test", lines.toString());

            return getPairsFromLines(lines);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Couldn't open file " + highscoreFile.getName());
            return null;
        }
    }

    /**
     * Retrieves all the scores that this object has access to
     *
     * @return a list of all the low scores in the form of a [name, score] tuple
     */
    private List<Pair<String, Integer>> getAllScores() {
        List<String> lines;
        try {
            lines = readLines();

            return getPairsFromLines(lines);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Couldn't open file " + highscoreFile.getName());
            return null;
        }
    }

    /**
     * Retrieves all the high scores that this object has access to
     * <p>
     * Implements method in ScoreboardRepository
     *
     * @return a list of all the high scores in the form of a [name, score] tuple
     */
    @Override
    public List<Pair<String, Integer>> getHighScores() {
        return getAllScores();
    }

    /**
     * Retrieves all the low scores that this object has access to
     * <p>
     * Implements method in ScoreboardRepository
     *
     * @return a list of all the low scores in the form of a [name, score] tuple in increasing order
     */
    @Override
    public List<Pair<String, Integer>> getLowScores() {
        return getAllScores();
    }

    /**
     * Return whether or not the given string is a valid name to use for recording highscores
     *
     * @param name - the name to check
     * @return whether or not the given name can be used to record a highscore
     */
    @Override
    public boolean validName(String name) {
        return !name.contains(",");
    }

    /**
     * Read the requested number of lines from the highscore file, or the entirety of the file if
     * num > number of lines
     *
     * @param num - the number of lines to read from the file
     * @return - a List where each entry is a line of the highscore file
     * @throws FileNotFoundException - if the highscoreFile cannot be opened, the method will throw
     *                               an exception
     */
    private List<String> readLines(int num) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();

        Scanner scanner = new Scanner(highscoreFile);
        int counter = 0;
        while (scanner.hasNext() && counter < num) {
            lines.add(scanner.nextLine());
            counter++;
        }
        scanner.close();


        return lines;
    }

    /**
     * Read all the lines from the highscore file
     *
     * @return - a List where each entry is a line of the highscore file
     * @throws FileNotFoundException - if the highscoreFile cannot be opened, the method will throw
     *                               an exception
     */
    private List<String> readLines() throws FileNotFoundException {
        List<String> lines = new ArrayList<>();

        Scanner scanner = new Scanner(highscoreFile);
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();


        return lines;
    }


    /**
     * Takes in a List of Strings representing lines from a highscore file and returns a List of
     * Pairs representing the names and scores stored in the file
     *
     * @param lines - List of Strings that should contain the contents from some highscore file,
     *              formatted correctly; see documentation of setFile(File) method
     * @return a List of Pairs, representing the data parsed from each line of the file; each entry
     * in the output corresponds to the line in the input with the same index
     */
    private List<Pair<String, Integer>> getPairsFromLines(List<String> lines) {
        List<Pair<String, Integer>> pairs = new ArrayList<>();

        int comma = -1;
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    comma = i;
                    break;
                }
            }

            if (comma == -1) {
                // Return null if the line does not contain a comma, meaning it is not formatted correctly
                return null;
            }

            String name = line.substring(0, comma);
            String highscoreString = line.substring(comma + 1);

            int highscore;
            try {
                highscore = Integer.parseInt(highscoreString);
            } catch (NumberFormatException e) {
                Log.e(TAG, "Input file incorrectly formatted; score is not number");
                return null;
            }

            pairs.add(new Pair<>(name, highscore));
        }

        return pairs;
    }
}
