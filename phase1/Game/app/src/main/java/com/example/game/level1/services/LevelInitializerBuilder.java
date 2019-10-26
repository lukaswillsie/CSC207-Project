package com.example.game.level1.services;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.example.game.level1.activities.BlackjackPlayActivity;
import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.game_logic.BlackjackInitializer;
import com.example.game.level1.game_logic.LevelInitializer;

import java.util.ArrayList;
import java.util.List;

public class LevelInitializerBuilder {
    public LevelInitializer buildLevelInitializer(Activity activity) {
        TextView userHand = activity.findViewById(BlackjackPlayActivity.PLAYER_HAND_ID);
        TextView dealerHand = activity.findViewById(BlackjackPlayActivity.DEALER_HAND_ID);

        List<Button> buttons = new ArrayList<Button>();
        for (int id : BlackjackPlayActivity.buttonIds) {
            buttons.add((Button) activity.findViewById(id));
        }

        ButtonManager buttonManager = new ButtonManager(buttons);

        return new BlackjackInitializer(userHand, dealerHand, buttonManager);
    }
}
