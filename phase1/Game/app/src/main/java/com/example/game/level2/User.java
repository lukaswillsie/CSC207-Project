package com.example.game.level2;
import java.util.ArrayList;

public class User {
    /**
     * Username of this user
     */
    String username;

    /**
     * The array that stores all the games this user has played.
     */
    ArrayList<Game> games;

    /**
     * The best score this user currently holds out of all their games played.
     */
    int bestScore;

    /**
     * Create a new instance of a user.
     * @param username  The username of this user.
     */
    User(String username) {
        this.username = username;
        games = new ArrayList<>();
        bestScore = 0;
    }


}
