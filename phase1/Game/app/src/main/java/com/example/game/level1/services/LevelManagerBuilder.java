package com.example.game.level1.services;

import android.widget.Button;
import android.widget.TextView;

import com.example.game.level1.activities.BlackjackPlayActivity;
import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.domain.Dealer;
import com.example.game.level1.domain.Deck;
import com.example.game.level1.domain.Player;
import com.example.game.level1.game_logic.BlackjackInterfaceManager;
import com.example.game.level1.game_logic.BlackjackLevelManager;
import com.example.game.level1.game_logic.InterfaceManager;
import com.example.game.level1.game_logic.LevelManager;

import java.util.ArrayList;
import java.util.List;

public class LevelManagerBuilder {
    public LevelManager buildLevelManager(BlackjackPlayActivity activity) {
        TextView userHand = activity.findViewById(BlackjackPlayActivity.PLAYER_HAND_ID);
        TextView dealerHand = activity.findViewById(BlackjackPlayActivity.DEALER_HAND_ID);

        List<Button> buttons = new ArrayList<Button>();
        for (int id : BlackjackPlayActivity.buttonIds) {
            buttons.add((Button) activity.findViewById(id));
        }

        Player user = new Player();
        Dealer dealer = new Dealer();
        Deck deck = new Deck();

        InterfaceManager interfaceManager = new BlackjackInterfaceManager(user, dealer, userHand, dealerHand);

        ButtonManager buttonManager = new ButtonManager(buttons);

        LevelManager manager = new BlackjackLevelManager(user, dealer, deck, interfaceManager, buttonManager);
        manager.setActivity(activity);

        return manager;
    }
}
