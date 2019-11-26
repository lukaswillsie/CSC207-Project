package com.example.game.services;

import android.content.Context;

import com.example.game.data.MultiplayerDoubleData;
import com.example.game.data.MultiplayerIntData;

import java.util.HashMap;

public class MultiplayerFileDataManager implements MultiplayerDataManager{
    /**
     * Stores all the data from the multiplayer data so that it can be accessed at runtime
     *
     * This HashMap
     */
    private static HashMap<String, Number> values;

    /**
     * Used to store player1's username while the game is running
     */
    private static String player1Username;

    /**
     * The key used to store player 2's username while the game is running
     */
    private static String player2Username;

    public MultiplayerFileDataManager(){
        values = new HashMap<>();

        // Populate the HashMap with the default values of all the required int statistics
        for(MultiplayerIntData intData: MultiplayerIntData.values()){
            values.put(intData.getKey(), intData.getDefaultValue());
        }

        // Populate the HashMap with the default values of all the required int statistics
        for(MultiplayerDoubleData doubleData : MultiplayerDoubleData.values()){
            values.put(doubleData.getKey(), doubleData.getDefaultValue());
        }

        player1Username = "Player 1";
        player2Username = "Player 2";
    }

    @Override
    public void setPlayer1Username(String newUsername) {
        player1Username = newUsername;
    }

    @Override
    public void setPlayer2Username(String newUsername) {
        player2Username = newUsername;
    }

    @Override
    public String getPlayer1Username() {
        return player1Username;
    }

    @Override
    public String getPlayer2Username() {
        return player2Username;
    }

    @Override
    public void setMultiplayerData(MultiplayerIntData dataType, int newValue) {
        values.replace(dataType.getKey(), newValue);
    }

    @Override
    public void setMultiplayerData(MultiplayerDoubleData dataType, double newValue) {
        values.replace(dataType.getKey(), newValue);
    }

    @Override
    public int getMultiplayerData(MultiplayerIntData dataType) {
        return (int)values.get(dataType.getKey());
    }

    @Override
    public double getMultiplayerData(MultiplayerDoubleData dataType) {
        return (double)values.get(dataType.getKey());
    }
}
