package com.example.game.level1.domain;

public class Dealer extends Player {
    public static final String HIT_KEY = "H";
    public static final String STAND_KEY = "S";

    public String getMove() {
        if (this.getHand().computeBlackJackValue() <= 16) {
            return HIT_KEY;
        } else {
            return STAND_KEY;
        }
    }
}
