package com.example.game.services;

import com.example.game.data.MultiplayerDoubleData;
import com.example.game.data.MultiplayerIntData;

public class TestMultiplayerDataManager implements MultiplayerDataManager {
    @Override
    public void setPlayer1Username(String player1Username) {

    }

    @Override
    public void setPlayer2Username(String player2Username) {

    }

    @Override
    public String getPlayer1Username() {
        return "LUKAS";
    }

    @Override
    public String getPlayer2Username() {
        return "PETER";
    }

    @Override
    public void setMultiplayerData(MultiplayerIntData dataType, int newValue) {

    }

    @Override
    public void setMultiplayerData(MultiplayerDoubleData dataType, double newValue) {

    }

    @Override
    public int getMultiplayerData(MultiplayerIntData dataType) {
        return 12;
    }

    @Override
    public double getMultiplayerData(MultiplayerDoubleData dataType) {
        return 75.00;
    }
}
