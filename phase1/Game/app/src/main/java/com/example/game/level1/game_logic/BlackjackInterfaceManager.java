package com.example.game.level1.game_logic;

import android.widget.TextView;

import com.example.game.level1.display.PlayerHandView;
import com.example.game.level1.display.PlayerInterpreter;
import com.example.game.level1.domain.Dealer;
import com.example.game.level1.domain.Player;


public class BlackjackInterfaceManager implements InterfaceManager {
    private PlayerInterpreter userInterpreter;
    private PlayerInterpreter dealerInterpreter;

    public BlackjackInterfaceManager(Player user, Dealer dealer, TextView userHand, TextView dealerHand) {
        userInterpreter = new PlayerInterpreter(user, new PlayerHandView(userHand));
        dealerInterpreter = new PlayerInterpreter(dealer, new PlayerHandView(dealerHand));
    }

    public void update() {
        userInterpreter.updatePlayerHand();

        if (BlackjackLevelManager.playerTurn) {
            dealerInterpreter.updatePlayerHandHideFirstCard();
        } else {
            dealerInterpreter.updatePlayerHand();
        }
    }
}
