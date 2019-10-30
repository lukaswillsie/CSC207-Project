package com.example.game.services;

import android.content.Context;

public class SettingsManagerBuilder {
    /**
     * Build a SettingsManager for the user with the given username, from the given Context
     * @param context - the context that wants the SettingsManager
     * @param username - the username of the user whose settings the SettingsManager is going to
     *                 be working with
     * @return a SettingsManager for the given user
     */
    public SettingsManager build(Context context, String username){
        return new UserSettingsManager(context, username);
    }
}
