package com.example.game.level1.game_logic;

public interface GameInitializer {
    /**
     * Call this method to get the game ready to be played
     */
    void setup();

    /**
     * Call this method to allow the game to be played
     */
    void play();
}
