package com.example.game.services;

public class MultiplayerDataManagerFactory {
    public MultiplayerDataManager build() {
        return new MultiplayerFileDataManager();
    }
}
