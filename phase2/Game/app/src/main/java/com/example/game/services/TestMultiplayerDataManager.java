package com.example.game.services;

import com.example.game.data.MultiplayerDoubleData;
import com.example.game.data.MultiplayerIntData;

public class TestMultiplayerDataManager implements MultiplayerDataManager {
    private static int turn = 1;
    @Override
    public void setPlayer1Username(String player1Username) {

    }

    @Override
    public void setPlayer2Username(String player2Username) {

    }

    @Override
    public String getPlayer1Username() {
        return "lukas";
    }

    @Override
    public String getPlayer2Username() {
        return "peter";
    }

    @Override
    public void setMultiplayerData(MultiplayerIntData dataType, int newValue) {
        if(dataType == MultiplayerIntData.BLACKJACK_PLAYER_TURN){
            turn = newValue;
        }
    }

    @Override
    public void setMultiplayerData(MultiplayerDoubleData dataType, double newValue) {

    }

    @Override
    public int getMultiplayerData(MultiplayerIntData dataType) {
        if(dataType == MultiplayerIntData.BLACKJACK_PLAYER_TURN){
            return turn;
        }
        return 12;
    }

    @Override
    public double getMultiplayerData(MultiplayerDoubleData dataType) {
        return 75.00;
    }
}
