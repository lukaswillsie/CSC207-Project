package com.example.game.services;

public class MultiplayerDataManagerFactory {
    /**
     * To keep track of how many MultiplayerDataManagers have been created over the course of the run
     *
     * If counter = 0, when build() is called, we are going to need to initialize the MultiplayerFileDataManager
     */
    private static int counter = 0;

    public MultiplayerDataManager build() {
        MultiplayerFileDataManager manager = new MultiplayerFileDataManager();;

        if(counter == 0){
            manager.initialize();
            counter++;
        }
        return manager;
    }
}
