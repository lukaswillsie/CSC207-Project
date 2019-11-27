package com.example.game.services.multiplayer_data;

public class MultiplayerDataManagerFactory {
    /**
     * To keep track of how many MultiplayerDataManagers have been created over the course of the run
     * <p>
     * If counter = 0, when build() is called, we are going to need to initialize the MultiplayerStaticDataManager
     */
    private static int counter = 0;

    public MultiplayerDataManager build() {
        MultiplayerStaticDataManager manager = new MultiplayerStaticDataManager();

        if (counter == 0) {
            manager.initialize();
            counter++;
        }
        return manager;
    }
}
