package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.game.data.Setting;
import com.example.game.level2.GameStartActivity;
import com.example.game.level1.activities.BlackjackStartActivity;
import com.example.game.services.GameData;
import com.example.game.services.SettingsManager;
import com.example.game.services.SettingsManagerBuilder;

import java.io.File;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private static String tag = "com.example.game.MainActivity";
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = GameData.USERNAME;
        String welcomeText = "Welcome, " + username + "!";
        ((TextView)findViewById(R.id.welcomeText)).setText(welcomeText);

        File usersDir = getDir("users", 0);
        File[] users = usersDir.listFiles();
        for(File user : users){
            Log.i("XXXXXXXX", user.getName());
            if(user.isDirectory()){
                File[] files = user.listFiles();
                for(File file : files){
                    Log.i("XXXXXXXXX", file.getAbsolutePath());
                    try{
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNext()){
                            Log.i("XXXXXXXX", scanner.nextLine());
                        }
                    }
                    catch(Exception e){

                    }
                }
            }
        }
        //DarkMode Setting
        SettingsManager manager = new SettingsManagerBuilder().build(this,username);
        int temp = manager.getSetting(Setting.DARK_MODE);
        if (temp == 1){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void playBlackjack(View view){
        Intent intent = new Intent(this, BlackjackStartActivity.class);
        startActivity(intent);
    }
    public void chooseTheNum(View view){
        Intent intent = new Intent(this, GameStartActivity.class);
        startActivity(intent);
    }

    public void goToSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
