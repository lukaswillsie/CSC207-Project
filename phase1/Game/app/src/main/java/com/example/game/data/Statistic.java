package com.example.game.data;

public enum Statistic {
    FEWEST_GUESSES("FewestGuesses",0),
    LONGEST_STREAK("LongestStreak",0);

    private String key;
    private int startingValue;

    Statistic(String key, int startingValue){
        this.key = key;
        this.startingValue = startingValue;
    }

    public String getKey(){
        return key;
    }

    public int getStartingValue(){
        return startingValue;
    }
}
