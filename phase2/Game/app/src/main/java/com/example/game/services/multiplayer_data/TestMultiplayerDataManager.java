package com.example.game.services.multiplayer_data;

import com.example.game.data.MultiplayerDoubleData;
import com.example.game.data.MultiplayerIntData;

public class TestMultiplayerDataManager implements MultiplayerDataManager {
    private static int turn = 1;
    private static String player1Username = "";
    private static int player1LongestStreak = 0;
    private static double player1WinRate = 0.0;

    private static String player2Username = "";
    private static int player2LongestStreak = 0;
    private static double player2WinRate = 0.0;

    @Override
    public void setPlayer1Username(String newPlayer1Username) {
        player1Username = newPlayer1Username;
    }

    @Override
    public void setPlayer2Username(String newPlayer2Username) {
        player2Username = newPlayer2Username;
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
        switch(dataType){
            case BLACKJACK_PLAYER_TURN:
                turn = newValue;
                break;
            case BLACKJACK_PLAYER1_LONGEST_STREAK:
                player1LongestStreak = newValue;
                break;
            case BLACKJACK_PLAYER2_LONGEST_STREAK:
                player2LongestStreak = newValue;
                break;
        }
    }

    @Override
    public void setMultiplayerData(MultiplayerDoubleData dataType, double newValue) {
        switch (dataType){
            case BLACKJACK_PLAYER_1_WIN_RATE:
                player1WinRate = newValue;
                break;
            case BLACKJACK_PLAYER_2_WIN_RATE:
                player2WinRate = newValue;
                break;
        }
    }

    @Override
    public int getMultiplayerData(MultiplayerIntData dataType) {
        switch(dataType){
            case BLACKJACK_PLAYER_TURN:
                return turn;
            case BLACKJACK_PLAYER1_LONGEST_STREAK:
                return player1LongestStreak;
            case BLACKJACK_PLAYER2_LONGEST_STREAK:
                return player2LongestStreak;
            default:
                return 0;
        }
    }

    @Override
    public double getMultiplayerData(MultiplayerDoubleData dataType) {
        switch (dataType){
            case BLACKJACK_PLAYER_1_WIN_RATE:
                return player1WinRate;
            case BLACKJACK_PLAYER_2_WIN_RATE:
                return player2WinRate;
            default:
                return 0.0;
        }
    }
}
