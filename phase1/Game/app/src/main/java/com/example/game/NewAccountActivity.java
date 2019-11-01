package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.services.GameData;
import com.example.game.services.UserAccountManager;

/**
 * The page displayed when a user is creating a new account
 */
public class NewAccountActivity extends AppCompatActivity implements NewUserPage {
    private String username;
    private NewAccountActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        presenter = new NewAccountActivityPresenter(new UserAccountManager(this), this);
    }

    public void register(View view) {
        username = getUsername();
        presenter.registerNewUser(username, getPassword());
    }

    private String getPassword() {
        return ((TextView) findViewById(R.id.newAccountPasswordTextField)).getText().toString();
    }

    private String getUsername() {
        return ((TextView) findViewById(R.id.newAccountUsernameTextField)).getText().toString();
    }

    @Override
    public void login() {
        Intent intent = new Intent(this, MainActivity.class);
        GameData.setUsername(username);

        startActivity(intent);
    }

    @Override
    public void accountCreationError(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton("Ok", null).create().show();
    }
}
