package com.example.game.services;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static com.example.game.GameConstants.NAME_FILE_NAME;
import static com.example.game.GameConstants.SETTINGS_FILE_NAME;
import static com.example.game.GameConstants.STATS_FILE_NAME;
import static com.example.game.GameConstants.USERS_DIR_NAME;

public class UserAccountManager {
    /**
     * This class's tag for logging events
     */
    private static String tag = "com.example.game.services.UserAccountManager";

    /**
     * The strings that should be written into the settings file on creation of a new user
     */
    private static String[] settings = {"DarkMode=0", "BlackjackHands=5", "HighLowRounds=5"};

    /**
     * The strings that should be written into the stats file on creation of a new user
     */
    private static String[] stats = {"FewestGuesses=0", "LongestStreak=0"};

    /**
     * File object representing the "users" directory containing all the user accounts and
     * their data
     */
    private File usersDir;

    /**
     * Create a new UserAccountManager from the given context
     * @param context - the context in which this AccountManager is being created
     */
    public UserAccountManager(Context context){
        usersDir = context.getDir(USERS_DIR_NAME, 0);
    }

    /**
     * Check if the given username is associated with an account
     * @param username - the username to be checked
     * @return true if the the username is already associated with an account
     *         false otherwise
     */
    public boolean usernameExists(String username){
        File[] users = usersDir.listFiles();
        for(File userDir : users){
            if(userDir.getName().equals(username)){
                return true;
            }
        }

        return false;
    }

    /**
     * Records that a new user with the given username and name has
     * been created by creating a folder for them and filling their
     * files with the default values
     *
     * Precondition: the given username is not already associated with an account;
     *               userNamExists(username) has been called and returned false
     * @param username - the username of the account to be created
     * @param name - the name of the account to be created
     */
    public void createNewUser(String username, String name){
        File newUserDir = new File(usersDir, username);
        newUserDir.mkdir();

        File settings = new File(newUserDir, SETTINGS_FILE_NAME);
        File stats = new File(newUserDir, STATS_FILE_NAME);
        File nameFile = new File(newUserDir, NAME_FILE_NAME);

        fillDefaultValues(settings, stats, nameFile, name);
    }

    /**
     * Populate the given files with the default values for a new user
     * @param settingsFile - the file to fill with the default settings
     * @param statsFile - the file to fill with the default stats
     * @param nameFile - the file to put the user's name in
     * @param name - the name of the new user
     */
    private void fillDefaultValues(File settingsFile, File statsFile, File nameFile, String name){
        try{
            FileOutputStream settingStream = new FileOutputStream(settingsFile);
            FileOutputStream statsStream = new FileOutputStream(statsFile);
            FileOutputStream nameStream = new FileOutputStream(nameFile);
            for(String setting : settings){
                settingStream.write((setting + "\n").getBytes());
            }
            for(String stat: stats){
                statsStream.write((stat + "\n").getBytes());
            }
            nameStream.write(name.getBytes());
        }
        catch(IOException e) {
            Log.e(tag, "Failed to create default files for user");
        }
    }

    /**
     * Check if the given username and name are, together, associated with an account
     * @param username - the username to be checked
     * @param name - the name to be checked
     * @return true if there is an account under the given username with the given name
     *         false otherwise
     */
    public boolean userExists(String username, String name){
        return usernameExists(username) && nameIsValid(username, name);
    }

    /**
     * Check if the account associated with the given username has name as given by the other
     * parameter
     *
     * Precondition: there is an account associated with the given username. usernameExists(username)
     * has been called and returned true
     * @param username - the username to check
     * @param name - the name to check
     * @return true if the name associated with the given username is the same as the parameter name
     *         false otherwise
     */
    private boolean nameIsValid(String username, String name){
        File userFolder = new File(usersDir, username);
        File nameFile = new File(userFolder, NAME_FILE_NAME);

        boolean validName = false;
        try{
            Scanner scanner = new Scanner(nameFile);
            String nameFromFile = scanner.nextLine();
            if(name.equals(nameFromFile)){
                validName = true;
            }
        }
        catch (IOException e){
            Log.e(tag, "Failed to read user's name file");
        }

        return validName;
    }
}
