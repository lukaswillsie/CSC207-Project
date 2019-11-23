package com.example.game.data;

/**
 * A class for storing important game data at runtime
 * <p>
 * At the moment, the title of "important" is bestowed only on the player's username
 */
public class GameData {
    /**
     * The username of the player; to be set when the user logs in/creates a new account
     */
    public static String USERNAME;

    /**
     * A boolean representing whether or not the game is in multiplayer mode at any given moment
     */
    public static boolean MULTIPLAYER = false;

    /**
     * Change what value is being stored in USERNAME; to be called when a
     * user logs in/creates a new account
     *
     * @param username - the new username
     */
    public static void setUsername(String username) {
        USERNAME = username;
    }

    /**
     * Change what value is being sotred in MULTIPLAYER; to be called when a user logs in/creates a
     * new account
     */
    public static void setMultiplayer(boolean multiplayer) {
        MULTIPLAYER = multiplayer;
    }
}
