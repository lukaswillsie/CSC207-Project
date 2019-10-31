package com.example.game.services;

import android.content.Context;
import android.util.Log;

import com.example.game.data.Statistic;

import java.io.File;

import static com.example.game.GameConstants.SETTINGS_FILE_NAME;
import static com.example.game.GameConstants.USERS_DIR_NAME;

public class UserStatsManager implements StatsManager {

    /**
     * This class's tag for logging things
     */
    private String tag = "com.example.game.services.UserStatsManager";

    /**
     * The file containing the user's settings
     */
    private File statsFile;

    /**
     * Create a new UserSettingsManager for the user with the given username
     * @param context - the calling context
     * @param username - the user's username
     */
    public UserStatsManager(Context context, String username) {
        // Open the user's settings file and store it in settingsFile
        statsFile = userStatsFile(context, username);
    }

    /**
     *
     * @param statistic - Statistic enum
     * @return - returns the value associated with the Statistic enum
     */
    @Override
    public int getStat(Statistic statistic) {

        return statistic.getValue();
    }

    @Override
    public void setStat(Statistic statistic, int value) {


    }

    /**
     * Return a File object for the given user's settings file
     * @param context - the context that created this object
     * @param username - the username of the user
     * @return a File object that contains the given user's settings file
     */
    private File userStatsFile(Context context, String username) {
        // Navigate to rootDirectoryOfApp/USERS_DIR_NAME/username/SETTINGS_FILE_NAME, opening
        // the user's settings file
        File rootDir = context.getDir(USERS_DIR_NAME, 0);
        Log.i(tag, ""+ rootDir.getName());
        File usersDir = new File(rootDir, username);
        return new File(usersDir, SETTINGS_FILE_NAME);
    }
}
