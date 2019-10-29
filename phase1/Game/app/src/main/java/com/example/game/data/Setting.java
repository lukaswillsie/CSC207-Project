package com.example.game.data;

public enum Setting {
    NUM_HANDS("NumHands", 5),
    NUM_ROUNDS("NumRounds", 5),
    blah("blah", 4),
    bleh("bleh", 6);

    /**
     * The key that will be used to store this setting in the settings file
     * For example:
     * NUM_HANDS.key = "NumHands" means that the settings file will contain
     * <p>
     * NumHands=
     * <p>
     * followed by the value for that setting
     */
    private String key;

    /**
     * The default value for this setting
     */
    private int defaultValue;

    Setting(String key, int defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public int getDefaultValue() {
        return defaultValue;
    }
}
