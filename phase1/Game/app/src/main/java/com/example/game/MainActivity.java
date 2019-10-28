package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.game.level2.GameStartActivity;
import com.example.game.level1.activities.BlackjackStartActivity;

import java.io.File;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public static String tag = "com.example.game";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        File userDir = getDir("users", 0);
        File[] users = userDir.listFiles();

        for(File user : users){
            if(user.isDirectory()) {
                for(File file : user.listFiles()){
                    Log.i(tag, file.toString());
                    try{
                        Scanner scanner = new Scanner(file);
                        while(scanner.hasNext()){
                            Log.i(tag, scanner.nextLine());
                        }
                    }
                    catch (Exception e){}
                }

            }
        }
    }

    public void buttonClick(View view){
        Intent intent = new Intent(this, BlackjackStartActivity.class);
        startActivity(intent);
    }
    public void chooseTheNum(View view){
        Intent intent = new Intent(this, GameStartActivity.class);
        startActivity(intent);
    }
}
