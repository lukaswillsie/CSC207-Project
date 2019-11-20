package com.example.game.BlackjackGame.services;

import android.widget.TextView;

import com.example.game.BlackjackGame.activities.BlackjackPlayActivity;
import com.example.game.BlackjackGame.domain.BlackjackPlayerManager;
import com.example.game.BlackjackGame.domain.Deck;
import com.example.game.BlackjackGame.domain.Player;
import com.example.game.BlackjackGame.game_logic.BlackjackInterfaceManager;
import com.example.game.BlackjackGame.game_logic.BlackjackLevelManager;
import com.example.game.BlackjackGame.game_logic.InterfaceManager;
import com.example.game.data.Setting;
import com.example.game.services.GameData;
import com.example.game.services.SettingsManagerBuilder;
import com.example.game.services.StatsManager;
import com.example.game.services.StatsManagerBuilder;

/**
 * A class that exists solely to build complex BlackjackLevelManagers
 */
public class BlackjackLevelManagerBuilder {
    /**
     * Build a new LevelManager for the given activity
     *
     * @param activity -  the activity that wants the BlackjackManager
     * @return a BlackjackLevelManager object
     */
    public BlackjackLevelManager build(BlackjackPlayActivity activity) {
        TextView userHand = activity.findViewById(BlackjackPlayActivity.PLAYER_HAND_ID);
        TextView dealerHand = activity.findViewById(BlackjackPlayActivity.DEALER_HAND_ID);

        Player user = new Player();
        Player dealer = new Player();

        BlackjackPlayerManager userManager = new BlackjackPlayerManager(user);
        BlackjackPlayerManager dealerManager = new BlackjackPlayerManager(dealer);
        Deck deck = new Deck();

        InterfaceManager interfaceManager = new BlackjackInterfaceManager(user, dealer, userHand, dealerHand);
        BlackjackLevelManager levelManager = new BlackjackLevelManager(userManager, dealerManager, deck, interfaceManager, activity);
        levelManager.setNumHands(new SettingsManagerBuilder().build(activity, GameData.USERNAME).getSetting(Setting.NUM_HANDS));

        return levelManager;
    }
}
