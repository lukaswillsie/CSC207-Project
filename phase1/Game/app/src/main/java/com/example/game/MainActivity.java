package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.game.GameConstants.PASSWORD_KEY;
import static com.example.game.GameConstants.TAG;
import static com.example.game.GameConstants.USERNAME_KEY;

import com.example.game.data.Setting;
import com.example.game.level2.GameStartActivity;
import com.example.game.level1.activities.BlackjackStartActivity;
import com.example.game.services.UserSettingsManager;

import java.io.File;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private static String tag = "com.example.game.MainActivity";
    private String password;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = getIntent().getStringExtra(TAG + PASSWORD_KEY);
        username = getIntent().getStringExtra(TAG + USERNAME_KEY);
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
                        Log.i("XXXXXXXX", scanner.nextLine());
                    }
                    catch(Exception e){

                    }
                }
            }
        }

        UserSettingsManager settingsManager = new UserSettingsManager(this, username);
        Log.i(tag, "" + settingsManager.getSetting(Setting.NUM_HANDS));

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
        intent.putExtra(TAG + PASSWORD_KEY, password);
        intent.putExtra(TAG + USERNAME_KEY, username);
        startActivity(intent);
    }
}
