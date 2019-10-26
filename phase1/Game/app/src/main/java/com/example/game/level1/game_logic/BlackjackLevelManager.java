package com.example.game.level1.game_logic;

import android.view.View;

import com.example.game.R;
import com.example.game.level1.display.ButtonManager;
import com.example.game.level1.domain.Deck;
import com.example.game.level1.domain.Player;

public class BlackjackLevelManager implements LevelManager {
    enum GameState {
        PLAYER_WIN,
        PLAYER_LOSE,
        PLAYER_BUST,
        PLAYER_TURN
    }
    private static final int HIT_BUTTON_ID = R.id.hitButton;
    private static final int STAND_BUTTON_ID = R.id.standButton;
    public static GameState gameState = GameState.PLAYER_TURN;

    private Player user;
    private Player dealer;
    private Deck deck;
    private InterfaceManager interfaceManager;
    private ButtonManager buttonManager;

    public BlackjackLevelManager(Player user, Player dealer, Deck deck, InterfaceManager interfaceManager, ButtonManager buttonManager) {
        this.user = user;
        this.dealer = dealer;
        this.deck = deck;
        this.interfaceManager = interfaceManager;
        this.buttonManager = buttonManager;
    }

    @Override
    public void setup() {
        deck.shuffle();

        user.deal(deck.deal(2));
        dealer.deal(deck.deal(2));
    }

    @Override
    public void play() {
        gameState = GameState.PLAYER_TURN;
        interfaceManager.update();
    }

    @Override
    public void userButtonClick(View view) {
        if (view.getId() == HIT_BUTTON_ID) {
            if (gameState == GameState.PLAYER_TURN) {
                user.deal(deck.deal());
                if(user.getHand().computeBlackJackValue() > 21){
                    endGame();
                }
            }
        } else if (view.getId() == STAND_BUTTON_ID) {
            buttonManager.disableButton(HIT_BUTTON_ID);
            buttonManager.disableButton(STAND_BUTTON_ID);
            endGame();
        }
    }

    private void endGame(){
        if(user.getHand().computeBlackJackValue() > 21){

        }
    }
}
