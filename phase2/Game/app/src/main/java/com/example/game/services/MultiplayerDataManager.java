package com.example.game.services;

import com.example.game.data.MultiplayerDoubleData;
import com.example.game.data.MultiplayerIntData;

/**
 * Defines what a class that manages multiplayer data while the program is running
 * should be able to do. Namely, update and return the usernames of the two players,
 * and store and access any numerical data the program deems necessary (this interface
 * supports storing and accessing double and int values).
 *
 * See below for details
 */
public interface MultiplayerDataManager {
    /**
     * The class has to be able to, at the very least, have a way of storing
     * the username of player 1
     *
     * @param player1Username - player 1's username
     */
    void setPlayer1Username(String player1Username);

    /**
     * The class has to be able to, at the very least, have a way of storing
     * the username of player 2
     *
     * @param player2Username - player 2's username
     */
    void setPlayer2Username(String player2Username);

    /**
     * Return the username of player 1
     * @return - player 1's username
     */
    String getPlayer1Username();

    /**
     * Return the username of player 2
     * @return - player 2's username
     */
    String getPlayer2Username();

    /**
     * Set the value of some kind of integer multiplayer data being tracked by the program.
     *
     * @param dataType - an enum value representing which statistic client code would like to update
     * @param newValue - the new value of the statistic
     */
    void setMultiplayerData(MultiplayerIntData dataType, int newValue);

    /**
     * Set the value of some kind of decimal multiplayer data being tracked by the program.
     *
     * @param dataType - an enum value representing which statistic client code would like to update
     * @param newValue - the new value of the statistic
     */
    void setMultiplayerData(MultiplayerDoubleData dataType, double newValue);

    /**
     * Access the value of some kind of integer multiplayer data being tracked by the program.
     *
     * @param dataType - an enum value representing which statistic client code would like to access
     * @return - the value of the requested statistic
     */
    int getMultiplayerData(MultiplayerIntData dataType);


    /**
     * Access the value of some kind of decimal multiplayer data being tracked by the program.
     *
     * @param dataType - an enum value representing which statistic client code would like to access
     * @return - the value of the requested statistic
     */
    double getMultiplayerData(MultiplayerDoubleData dataType);
}
