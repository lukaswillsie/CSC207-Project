package com.example.game.BlackjackGame.services;

import com.example.game.data.MultiplayerDoubleData;
import com.example.game.data.MultiplayerIntData;
import com.example.game.services.MultiplayerDataManager;

public class MultiplayerEndGameActivityPresenter {
    private MultiplayerDataManager multiplayerDataManager;

    public MultiplayerEndGameActivityPresenter(MultiplayerDataManager multiplayerDataManager) {
        this.multiplayerDataManager = multiplayerDataManager;
    }

    /**
     * Reset the multiplayer data being stored so that another game of multiplayer Blackjack can be
     * played from a fresh start
     */
    public void resetMultiplayerData() {
        // Reset the player turn value to 1 so that if another game is played, we start with player 1
        // again
        multiplayerDataManager.setMultiplayerData(MultiplayerIntData.BLACKJACK_PLAYER_TURN, 1);

        // Reset the win rate values to 0.0
        multiplayerDataManager.setMultiplayerData(MultiplayerDoubleData.BLACKJACK_PLAYER_1_WIN_RATE, 0.0);
        multiplayerDataManager.setMultiplayerData(MultiplayerDoubleData.BLACKJACK_PLAYER_2_WIN_RATE, 0.0);

        // Reset the longest win streak values to 0
        multiplayerDataManager.setMultiplayerData(MultiplayerIntData.BLACKJACK_PLAYER1_LONGEST_STREAK, 0);
        multiplayerDataManager.setMultiplayerData(MultiplayerIntData.BLACKJACK_PLAYER2_LONGEST_STREAK, 0);
    }
}
