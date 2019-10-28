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

public class OldAccountActivity extends AppCompatActivity {
    private static String tag = "com.example.game.OldAccountActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_account);
    }

    public void login(View view){
        String inputName = getName();
        String inputUsername = getUsername();

        UserAccountManager userAccountManager = new UserAccountManager(this);

        boolean validCredentials = userAccountManager.userExists(inputName, inputUsername);
        if(validCredentials){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(TAG + USERNAME_KEY, inputUsername);
            intent.putExtra(TAG + NAME_KEY, inputName);
            startActivity(intent);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("That account does not exist!").setPositiveButton("Ok", null).create().show();
        }
    }

    private String getName(){
        return ((TextView)findViewById(R.id.oldAccountNameTextField)).getText().toString();
    }

    private String getUsername(){
        return ((TextView)findViewById(R.id.oldAccountUsernameTextField)).getText().toString();
    }
}
