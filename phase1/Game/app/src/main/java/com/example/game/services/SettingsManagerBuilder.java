package com.example.game.services;

import android.content.Context;

public class SettingsManagerBuilder {
    public SettingsManager build(Context context, String username){
        return new UserSettingsManager(context, username);
    }
}
