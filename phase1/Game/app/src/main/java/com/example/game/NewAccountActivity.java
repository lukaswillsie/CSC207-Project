package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewAccountActivity extends AppCompatActivity {
    private static String[] settings = {"DarkMode=0", "BlackjackHands=5", "HighLowRounds=5"};
    private static String[] stats = {"FewestGuesses=0", "LongestStreak=0"};
    private static String tag = "com.example.game.NewAccountActivity";
    private File usersDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        usersDir = getDir("users", 0);
    }

    public void register (View view){
        String username = getUserName();
        String name = getName();

        File[] users = usersDir.listFiles();
        for(File userDir : users){
            if(userDir.getName().equals(username)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("That account already exists!").setPositiveButton("Ok", null).create().show();
                return;
            }
        }

        createNewUser(username, name);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.tag + ".username", username);
        intent.putExtra(MainActivity.tag + ".name", name);

        startActivity(intent);
    }

    private String getName(){
        return ((TextView)findViewById(R.id.newAccountUsernameTextField)).getText().toString();
    }

    private String getUserName(){
        return ((TextView)findViewById(R.id.newAccountUsernameTextField)).getText().toString();
    }

    private void createNewUser(String username, String name){
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
}
