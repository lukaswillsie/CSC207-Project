package com.example.game.level2;

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

}