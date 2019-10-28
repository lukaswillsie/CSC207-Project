package com.example.game.services;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class UserAccountManager {
    private static String tag = "com.example.game.services.UserAccountManager";
    private static String[] settings = {"DarkMode=0", "BlackjackHands=5", "HighLowRounds=5"};
    private static String[] stats = {"FewestGuesses=0", "LongestStreak=0"};
    private static final String USERS_DIR_NAME = "users";
    private File usersDir;

    public UserAccountManager(Context context){
        usersDir = context.getDir(USERS_DIR_NAME, 0);
    }

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

        File settings = new File(newUserDir, "settings");
        File stats = new File(newUserDir, "stats");
        File nameFile = new File(newUserDir, "name");

        fillDefaultValues(settings, stats, nameFile, name);
    }

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

    public boolean userExists(String username, String name){
        return usernameExists(username) && nameIsValid(username, name);
    }

    private boolean nameIsValid(String username, String name){
        File userFolder = new File(usersDir, username);
        File nameFile = new File(userFolder, "name");

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
