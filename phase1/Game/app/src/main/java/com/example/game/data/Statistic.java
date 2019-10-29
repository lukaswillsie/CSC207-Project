package com.example.game.data;

public enum Statistic {
    FEWEST_GUESSES("FewestGuesses",0),
    LONGEST_STREAK("LongestStreak",0);

    /**
     * The key that will be used to store this statistic in the stats file
     * For example:
     *
     * FEWEST_GUESSES.key = "FewestGuesses" means that in the stats file there will be the line
     *
     * FewestGuesses=
     *
     * followed by the value for this statistic
     */
    private String key;

    /**
     * The initial value of this statistic
     */
    private int initialValue;

    /**
     * Create a new Statistic with the given key and initial value
     * @param key - the key of this Statistic
     * @param initialValue - the initial value of this Statistic
     */
    Statistic(String key, int initialValue){
        this.key = key;
        this.initialValue = initialValue;
    }

    /**
     * Get the key of this Statistic
     * @return - the key of this Statistic
     */
    public String getKey(){
        return key;
    }

    /**
     * Get the initial value of this Statistic
     * @return - the initial value of this statistic
     */
    public int getInitialValue(){
        return initialValue;
    }
}
