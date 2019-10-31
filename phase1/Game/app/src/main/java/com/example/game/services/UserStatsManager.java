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
     * Create a new UserStatsManager for the user with the given username
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
     * Return a File object for the given user's stats file
     * @param context - the context that created this object
     * @param username - the username of the user
     * @return a File object that contains the given user's stats file
     */
    private File userStatsFile(Context context, String username) {
        // Navigate to rootDirectoryOfApp/USERS_DIR_NAME/username/SETTINGS_FILE_NAME, opening
        // the user's settings file
        File rootDir = context.getDir(USERS_DIR_NAME, 0);
        Log.i(tag, ""+ rootDir.getName());
        File usersDir = new File(rootDir, username);
        return new File(usersDir, SETTINGS_FILE_NAME);
    }


    /**
     * Takes a line from the stats file and extracts the stats that corresponds to that line from
     * the string
     * For example:
     * getStatsKey("FewestGuesses=4") -> "FewestGuesses"
     * getSettingKey("QuickestTime=1") -> "QuickestTime"
     *
     * @param line - the string to be parsed for a stat
     * @return an empty string if this String does not contain an equals, a substring of all
     * characters preceding the equals otherwise (this is  the format of a line from the settings file)
     */
    private String getStatsKey(String line){
        Log.i(tag,"Line: \"" + line + "\"");
        int equalsIndex=-1;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '='){
                equalsIndex = i;
                break;
            }
        }
        if(equalsIndex >= 0){
            return line.substring(0, equalsIndex);
        }

        return "";

    }

    /**
     * Takes a line from the stats file and returns the value stored on that line
     * For example:
     * getSettingKey("FewestGuesses=4") -> 4
     * getSettingKey("QuickestTime=1") -> 1
     *
     * @param line - the line to be parsed for a value
     * @return returns -1 if a proper integer cannot be parsed from the given String, returns the
     * stats value from the given line otherwise
     */
    private int getStatsValue(String line){
        int equalsIndex=-1;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '='){
                equalsIndex = i+1;
                break;
            }
        }
        try {
            return Integer.parseInt(line.substring(equalsIndex));
        }
        catch(NumberFormatException e) {
            Log.e(tag, "Could not parse setting value from line");

            return -1;
        }
    }


}
