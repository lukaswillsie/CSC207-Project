package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.services.AccountManager;
import com.example.game.services.GameData;
import com.example.game.services.UserAccountManager;

public class OldAccountActivity extends AppCompatActivity {
    private static String tag = "com.example.game.OldAccountActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_account);
    }

    public void login(View view){
        String inputPassword = getPassword();
        String inputUsername = getUsername();

        AccountManager userAccountManager = new UserAccountManager(this);

        boolean validCredentials = userAccountManager.validCredentials(inputUsername, inputPassword);
        if(validCredentials){
            Intent intent = new Intent(this, MainActivity.class);
            GameData.setUsername(inputUsername);
            startActivity(intent);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Your login information is incorrect").setPositiveButton("Ok", null).create().show();
        }
    }

    private String getPassword(){
        return ((TextView)findViewById(R.id.oldAccountPasswordTextField)).getText().toString();
    }

    private String getUsername(){
        return ((TextView)findViewById(R.id.oldAccountUsernameTextField)).getText().toString();
    }
}
