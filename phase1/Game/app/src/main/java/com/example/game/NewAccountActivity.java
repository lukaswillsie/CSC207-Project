package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.game.GameConstants.NAME_KEY;
import static com.example.game.GameConstants.TAG;
import static com.example.game.GameConstants.USERNAME_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.services.UserAccountManager;

public class NewAccountActivity extends AppCompatActivity {
    private static String tag = "com.example.game.NewAccountActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
    }

    public void register (View view){
        String username = getUsername();
        String name = getName();

        UserAccountManager userManager = new UserAccountManager(this);

        if(userManager.usernameExists(username)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("That username already exists!").setPositiveButton("Ok", null).create().show();
            return;
        }


        userManager.createNewUser(username, name);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TAG + USERNAME_KEY, username);
        intent.putExtra(TAG + NAME_KEY, name);

        startActivity(intent);
    }

    private String getName(){
        return ((TextView)findViewById(R.id.newAccountNameTextField)).getText().toString();
    }

    private String getUsername(){
        return ((TextView)findViewById(R.id.newAccountUsernameTextField)).getText().toString();
    }
}
