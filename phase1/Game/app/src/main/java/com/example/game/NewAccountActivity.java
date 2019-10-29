package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.game.GameConstants.PASSWORD_KEY;
import static com.example.game.GameConstants.TAG;
import static com.example.game.GameConstants.USERNAME_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.services.AccountManager;
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
        String password = getPassword();

        AccountManager userManager = new UserAccountManager(this);

        if(userManager.usernameExists(username)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("That username already exists!").setPositiveButton("Ok", null).create().show();
            return;
        }


        userManager.createNewUser(username, password);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TAG + USERNAME_KEY, username);
        intent.putExtra(TAG + PASSWORD_KEY, password);

        startActivity(intent);
    }

    private String getPassword(){
        return ((TextView)findViewById(R.id.newAccountPasswordTextField)).getText().toString();
    }

    private String getUsername(){
        return ((TextView)findViewById(R.id.newAccountUsernameTextField)).getText().toString();
    }
}
