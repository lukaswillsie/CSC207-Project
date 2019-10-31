package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.services.GameData;
import com.example.game.services.UserAccountManager;

public class OldAccountActivity extends AppCompatActivity implements OldUserPage {
    private static String tag = "com.example.game.OldAccountActivity";
    private OldAccountActivityPresenter presenter;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_account);

        presenter = new OldAccountActivityPresenter(new UserAccountManager(this), this);
    }

    public void login(View view){
        username = getUsername();
        presenter.loginNewUser(username, getPassword());
    }

    private String getPassword(){
        return ((TextView)findViewById(R.id.newAccountPasswordTextField)).getText().toString();
    }

    private String getUsername(){
        return ((TextView)findViewById(R.id.oldAccountUsernameTextField)).getText().toString();
    }

    @Override
    public void login() {
        Intent intent = new Intent(this, MainPageActivity.class);
        GameData.setUsername(username);
        startActivity(intent);
    }

    @Override
    public void loginError(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton("Ok", null).create().show();
    }
}
