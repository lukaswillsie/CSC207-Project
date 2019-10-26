package com.example.game.level2;

import java.lang.Math;

public class Game {
    /**
     * Name of the person, playing the game.
     */
    String username;
    /**
     * Number of guesses, that this user has used.
     */
    int numOfGuess;
    /**
     * time spent to guess the number.
     */
    String time;
    /**
     * Total number of point that user receives for the game.
     */
    int points;
    /**
     * Number to guess.
     */
    int number;
    /**
     * Create a new Game for User.
     */
    public Game(User user){
        this.username = user.username;
        this.numOfGuess = 0;
        this.time = "";
        this.points = 0;
        this.number = (int)(Math.random() * 50 + 1); //!!!!! CHANGE NEEDED.
    }

    public String checkGuess(int guess) {
        this.updateStats(guess);

        if (guess < this.number) {
            return "Your guess is LOW.";
        }
        else if (guess > this.number) {
            return "Your guess is HIGH.";
        }
        else {
            // goes to the page where it says congrats, go to main menu
            return "CONGRATS.";
        }
    }

    private void updateStats(int guess) {
        this.numOfGuess++;
        this.points += Math.abs(this.number - guess);

    }
    private String gameFinished(){
        return "CONGRATS.";
        //this.stopTheGame();
    }
}
