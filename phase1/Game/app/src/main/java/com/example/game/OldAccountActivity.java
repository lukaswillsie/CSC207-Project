package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OldAccountActivity extends AppCompatActivity {
    private static String tag = "com.example.game.OldAccountActivity";
    private File usersDir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_account);

        usersDir =  getDir("users", 0);
    }

    public void login(View view){
        String inputName = getName();
        String inputUsername = getUsername();


        boolean validUsername = usernameIsValid(inputUsername);
        if(validUsername)
        {
            boolean validName = nameIsValid(inputName, inputUsername);
            if(validName){
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(MainActivity.tag + ".username", inputUsername);
                intent.putExtra(MainActivity.tag + ".name", inputName);
                startActivity(intent);
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("That name is incorrect!").setPositiveButton("Ok", null).create().show();
            }
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("That username does not exist!").setPositiveButton("Ok", null).create().show();
        }
    }

    private boolean usernameIsValid(String inputUsername){
        File[] users = usersDir.listFiles();

        boolean foundUsername = false;
        for(File user : users){
            if(user.getName().equals(inputUsername)){
                foundUsername = true;
                break;
            }
        }

        Log.i(tag, "Username " + inputUsername + " is valid.");
        return foundUsername;
    }

    private boolean nameIsValid(String inputName, String inputUsername){
        File userFolder = new File(usersDir, inputUsername);
        File nameFile = new File(userFolder, "name");

        boolean validName = false;
        try{
            Scanner scanner = new Scanner(nameFile);
            String name = scanner.nextLine();
            if(inputName.equals(name)){
                validName = true;
            }
        }
        catch (IOException e){
            Log.e(tag, "Failed to read user's name file");
        }

        return validName;
    }

    private String getName(){
        return ((TextView)findViewById(R.id.oldAccountNameTextField)).getText().toString();
    }

    private String getUsername(){
        return ((TextView)findViewById(R.id.oldAccountUsernameTextField)).getText().toString();
    }
}
