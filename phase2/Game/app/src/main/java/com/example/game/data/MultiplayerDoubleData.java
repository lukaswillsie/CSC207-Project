package com.example.game.data;

/**
 * An enum defining what kinds of data take on decimal values and will need to be stored during the
 * course of a multiplayer game
 */
public enum MultiplayerDoubleData {
    ;
    /**
     * The initial, default value of this particular statistic. What the statistic
     * should be initialized to at runtime when a multiplayer game starts
     */
    private int defaultValue;

    /**
     * The key to be used when storing the value. For example. If key="key1", then if the
     * multiplayer data is being stored in a file we would have:
     * ...
     * ...
     * ...
     * ...
     * key1=0.5
     * ...
     * ...
     * ...
     * or something similar in that file, meaning that the value of the statistic with key "key1"
     * is 0.5
     */
    private String key;

    /**
     * Initialize a new MultiplayerData object
     *
     * @param defaultValue - the default value of this statistic
     * @param key          - the key to be used when storing this statistic
     */
    MultiplayerDoubleData(int defaultValue, String key) {
        this.defaultValue = defaultValue;
        this.key = key;
    }

    /**
     * Access the default value of this MultiplayerData object
     *
     * @return - the default value of this MultiplayerData object
     */
    public int getDefaultValue() {
        return defaultValue;
    }

    /**
     * Access the key of this MultiplayerData object
     *
     * @return - the key of this MultiplayerData object
     */
    public String getKey() {
        return key;
    }
}
